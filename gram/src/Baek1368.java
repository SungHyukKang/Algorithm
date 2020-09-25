import java.util.*;
import java.io.*;
class Node1368 implements Comparable<Node1368>{
	int s;
	int e;
	int d;
	Node1368(int s,int e ,int d){
		this.s=s;
		this.e=e;
		this.d=d;
	}
	@Override
	public int compareTo(Node1368 arg0) {
		return this.d<=arg0.d ? -1:1;
	}
}
public class Baek1368 {
	
	static int[] parent;
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static int find(int start) {
		if(parent[start]==start) {
			return start;
		}
		parent[start]=find(parent[start]);
		return parent[start];
	}
	
	public static void union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot!=bRoot) {
			parent[aRoot]=b;
		}else
			return;
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node1368> pq = new PriorityQueue<Node1368>();
		int N =stoi(br.readLine());
		parent = new int[N+1];
		for(int i =1;i<=N;i++) {
			parent[i]=i;
		}
		for(int i =1;i<=N;i++) {
			int X = stoi(br.readLine());
			pq.offer(new Node1368(0,i,X));
			
		}
		StringTokenizer st;
		for(int i =1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j =1;j<=N;j++) {
				int num = stoi(st.nextToken());
				if(i>=j) {
					pq.offer(new Node1368(i,j,num));
				}
			}
		}
		int sum=0;
		while(!pq.isEmpty()) {
			Node1368 n = pq.poll();
			int s= n.s;
			int e=n.e;
			int d= n.d;
			int a =find(s);
			int b =find(e);
			if(a==b)
				continue;
				sum+=d;
			union(s,e);
		}
		System.out.println(sum);
	}
}
