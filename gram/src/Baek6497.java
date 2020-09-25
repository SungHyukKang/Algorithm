import java.util.*;
import java.io.*;

class Node6497 implements Comparable<Node6497>{
	int start;
	int end;
	int dist;
	
	Node6497(int s, int e, int d){
		this.start =s ;
		this.end=e;
		this.dist=d;
	}
	
	@Override
	public int compareTo(Node6497 o) {
		return this.dist<=o.dist ? -1 : 1;
	}
}

public class Baek6497 {
	static int[] parent ;
	public static int stoi(String X) {return Integer.parseInt(X);}
	static int find(int start) {
		if(parent[start]==start) {
			return start;
		}
		parent[start]=find(parent[start]);
		return parent[start];
	}
	
	static void union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		if(aRoot!=bRoot) {
			parent[aRoot]=b;
		}else
			return;
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		PriorityQueue<Node6497> pq= new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =stoi(st.nextToken());
		int M =stoi(st.nextToken());
		if(N==0&&M==0) {
			return;
		}
		parent= new int[N];
		for(int i =0;i<N;i++)
			parent[i]=i;
		long distance=0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num=stoi(st.nextToken());
			int num2=stoi(st.nextToken());
			int num3=stoi(st.nextToken());
			distance+=num3;
			pq.offer(new Node6497(num,num2,num3));
		}
		long sum=0;
		for(int i =0;i<M;i++) {
			Node6497 n = pq.poll();
			int s = n.start;
			int e = n.end;
			int dist = n.dist;
			int a = find(s);
			int b = find(e);
			if(a==b)
				continue;
			union(s,e);
			sum+=dist;
		}
		System.out.println(distance-sum);
		}
	}
}
