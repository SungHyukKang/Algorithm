import java.util.*;
import java.io.*;

class NodeX implements Comparable<NodeX>{
	int s;
	int e;
	int d;
	
	NodeX(int s, int e, int d){
		this.s=s;
		this.e=e;
		this.d=d;
	}

	@Override
	public int compareTo(NodeX o) {
		return this.s<=o.s ? -1 : 1;
	}
}

class Node13418 implements Comparable<Node13418>{
	int s;
	int e;
	int d;
	
	Node13418(int s, int e, int d){
		this.s=s;
		this.e=e;
		this.d=d;
	}

	@Override
	public int compareTo(Node13418 arg0) {
		return this.d>=arg0.d ? -1 : 1;
	}
}


class Node13418x implements Comparable<Node13418x>{
	int s;
	int e;
	int d;
	
	Node13418x(int s, int e, int d){
		this.s=s;
		this.e=e;
		this.d=d;
	}

	public int compareTo(Node13418x arg0) {
		return this.d<=arg0.d ? -1 : 1;
	}
}

public class Baek13418 {
	static int[] parent ;
	
	static int find(int s) {
		if(parent[s]==s) {
			return s;
		}
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
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N =stoi(st.nextToken());
		int M =stoi(st.nextToken());
		parent=new int[N+1];
		for(int i =0;i<=N;i++) {
			parent[i]=i;
			
		}
		PriorityQueue<Node13418> best = new PriorityQueue<Node13418>();
		PriorityQueue<NodeX> best2 = new PriorityQueue<NodeX>();
		PriorityQueue<Node13418x> worst= new PriorityQueue<Node13418x>();
		PriorityQueue<NodeX> worst2= new PriorityQueue<NodeX>();
		st=new StringTokenizer(br.readLine());
		int n1=stoi(st.nextToken());
		int n2=stoi(st.nextToken());;
		int n3=stoi(st.nextToken());;
		int cnt=0;
		union(n1,n2);
		best2.offer(new NodeX(n1,n2,n3));
		worst2.offer(new NodeX(n1,n2,n3));
		for(int i =0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int num = stoi(st.nextToken());
				int num2 = stoi(st.nextToken());
				int num3 = stoi(st.nextToken());
				best.offer(new Node13418(num,num2,num3));
				worst.offer(new Node13418x(num,num2,num3));
			}
		}
		int cnt2=0;
		while(!best.isEmpty()) {
			Node13418 n = best.poll();
			int s= n.s;
			int e=n.e;
			int d= n.d;
			int a =find(s);
			int b =find(e);
			if(a==b)
				continue;
			union(s,e);
			best2.offer(new NodeX(s, e, d));
			
		}
		for(int i =0;i<=N;i++) {
			parent[i]=i;
		}
		union(n1,n2);
		while(!worst.isEmpty()) {
			Node13418x n = worst.poll();
			int s= n.s;
			int e=n.e;
			int d= n.d;
			int a =find(s);
			int b =find(e);
			if(a==b)
				continue;
			union(s,e);
			worst2.offer(new NodeX(s, e, d));
		}
		int before=-1;
		for(NodeX nx : best2) {
			if(before==-1&&nx.d==0) {
				cnt++;
				continue;
			}
			if(before==1&&nx.d==0) {
				cnt++;
			}
		}
		before=-1;
		for(NodeX nx : worst2) {
			if(before==-1&&nx.d==0) {
				cnt2++;
				continue;
			}
			if(before==1&&nx.d==0) {
				cnt2++;
			}
		}
		
		int b=(int)Math.pow(cnt,2);
		int w=(int)Math.pow(cnt2,2);
		System.out.println(w-b);
	}
	
	
}
