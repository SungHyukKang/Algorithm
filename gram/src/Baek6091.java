import java.util.*;
import java.io.*;

class Node6091 implements Comparable<Node6091>{
	int s;
	int e;
	int d;
	
	Node6091(int s, int e, int d){
		this.s=s;
		this.e=e;
		this.d=d;
	}

	@Override
	public int compareTo(Node6091 o) {
		return this.d<=o.d ? -1:1;
	}
}
public class Baek6091 {
	static int[] parent;
	public static int stoi(String X) {return Integer.parseInt(X);}
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node6091> pq = new PriorityQueue<Node6091>();
		int N = stoi(br.readLine());
		parent = new int[N+1];
		for(int i =1;i<=N;i++) {
			parent[i]=i;
		}
		for(int i =1;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=i;j<=N;j++) {
				if(i>=j)
					continue;
				int num = stoi(st.nextToken());
				pq.offer(new Node6091(i,j,num));
			}
		}
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i =0;i<=N;i++) {
			list.add(new ArrayList<Integer>());
		}
		while(!pq.isEmpty()) {
			Node6091 n = pq.poll();
			int s = n.s;
			int e = n.e;
			int a = find(s);
			int b = find(e);
			if(a==b)
				continue;
			union(s,e);
			list.get(s).add(e);
			list.get(e).add(s);
		}
		for(int i =1;i<=N;i++) {
			Collections.sort(list.get(i));
			System.out.print(list.get(i).size()+" ");
			for(int j=0;j<list.get(i).size();j++) {
				System.out.print(list.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
	}
}