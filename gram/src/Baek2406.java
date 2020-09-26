import java.util.*;
import java.io.*;

class Node2406 implements Comparable<Node2406>{
	int s;
	int e;
	int d;
	
	public Node2406(int s, int e, int d) {
		this.s=s;
		this.d=d;
		this.e=e;
	}

	@Override
	public int compareTo(Node2406 o) {
		return this.d<=o.d ? -1 : 1;
	}
	
}

public class Baek2406 {

	public static int[] parent;
	
	public static int stoi(String X ) {return Integer.parseInt(X);}
	public static int find(int s) {
		if(parent[s]==s)
			return s;
		parent[s]=find(parent[s]);
		return parent[s];
	}
	
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot!=bRoot) {
			parent[aRoot]=b;
		}else
			return;
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =	stoi(st.nextToken());
		int m =	stoi(st.nextToken());
		boolean[] visited = new boolean[n+1];
		int K = n;
		PriorityQueue<Node2406> pq = new PriorityQueue<Node2406>();
		parent = new int[n+1];
		for(int i =1;i<=n;i++) {
			parent[i]=i;
		}
		for(int i =0;i<m;i++) {
			st= new StringTokenizer(br.readLine());
			int s = stoi(st.nextToken());
			int e = stoi(st.nextToken());
			int a = find(s);
			int b = find(e);
			if(a==b)
				continue;
			union(s,e);
		}
		for(int i =1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j =1;j<=n;j++) {
				int d = stoi(st.nextToken());
				if(i>=j||i==1)
					continue;
				pq.offer(new Node2406(i,j,d));
			}
		}
		int sum=0;
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Node2406 node = pq.poll();
			int s= node.s;
			int e=node.e;
			int d=node.d;
			int a = find(s);
			int b = find(e);
			if(a==b)
				continue;
			union(s,e);
//			if(!visited[s]&&!visited[e]) {
				sum+=d;
				sb.append(s+" "+e+"\n");
//			}
			K--;
		}
		System.out.println(sum+" "+(n-K));
		System.out.println(sb);
	}

}
