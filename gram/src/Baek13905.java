import java.util.*;
import java.io.*;

class Node13905 implements Comparable<Node13905>{
	int s,e,d;
	
	Node13905(int s, int e,int d){
		this.s=s;
		this.e=e;
		this.d=d;
	}

	@Override
	public int compareTo(Node13905 o) {
		return this.d>=o.d?-1:1;
	}
	
}

public class Baek13905 {
	static int parent[];
	static int stoi(String X) {return Integer.parseInt(X);}
	static int find(int s) {
		if(parent[s]==s)
			return s;
		parent[s]=find(parent[s]);
		return parent[s];
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
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =stoi(st.nextToken());
		int M =stoi(st.nextToken());
		PriorityQueue<Node13905> pq = new PriorityQueue<>();
		parent = new int[N+1];
		for(int i =1;i<=N;i++) {
			parent[i]=i;
		}
		st= new StringTokenizer(br.readLine());
		int go= stoi(st.nextToken());
		int end= stoi(st.nextToken());
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num = stoi(st.nextToken());
			int num2 = stoi(st.nextToken());
			int num3 = stoi(st.nextToken());
			pq.offer(new Node13905(num , num2 ,num3));
		}
		while(!pq.isEmpty()) {
			Node13905 n= pq.poll();
			int s=n.s;
			int e=n.e;
			int d=n.d;
			int a = find(s);
			int b = find(e);
			if(a==b)
				continue;
			union(s,e);
			if(find(go)==find(end)) {
				System.out.println(d);
				return;
			}
		}
		System.out.println("0");
	}
}
