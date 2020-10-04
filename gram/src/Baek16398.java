import java.util.*;
import java.io.*;

class Node16398 implements Comparable<Node16398>{
	int s,e,d;
	
	Node16398(int s, int e,int d){
		this.s=s;
		this.e=e;
		this.d=d;
	}

	@Override
	public int compareTo(Node16398 o) {
		return this.d<=o.d? -1 : 1;
	}
	
}
public class Baek16398 {
	static int[] parent;
	
	public static int stoi(String X) {return Integer.parseInt(X);}
	static int find(int s) {
		if(parent[s]==s)
			return s;
		parent[s]=find(parent[s]);
		return parent[s];
	}
	
	static void union(int a,int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		if(aRoot!=bRoot)
			parent[aRoot]=b;
		else
			return;
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());
		StringTokenizer st;
		parent=new int[N];
		for(int i =0;i<N;i++)
			parent[i]=i;
		PriorityQueue<Node16398> pq = new PriorityQueue<Node16398>();
		for(int i =0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int num = stoi(st.nextToken());
				if(i>=j)
					continue;
				pq.offer(new Node16398(i,j,num));
			}
		}
		long sum=0;
		while(!pq.isEmpty()) {
			Node16398 n =pq.poll();
			int s=n.s;
			int e=n.e;
			int d=n.d;
			int a = find(s);
			int b = find(e);
			if(a==b)
				continue;
			union(s,e);
			sum+=d;
		}
		System.out.println(sum);
	}

}
