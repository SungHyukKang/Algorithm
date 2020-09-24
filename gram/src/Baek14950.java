import java.util.*;
import java.io.*;
class Node14950 implements Comparable<Node14950>{
	int start;
	int end;
	int dist;
	
	public Node14950(int s ,int e ,int d) {
		this.dist=d;
		this.start=s;
		this.end=e;
	}

	@Override
	public int compareTo(Node14950 o) {
		return this.dist<=o.dist ? -1:1;
	}
	
}

public class Baek14950 {
	
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
	static int[] parent;
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		PriorityQueue<Node14950> pq = new PriorityQueue<>( );
		
		int N =stoi(st.nextToken());
		int M =stoi(st.nextToken());
		int t =stoi(st.nextToken());
		parent =new int[N+1];
		for(int i =1;i<=N;i++) {
			parent[i]=i;
		}
		for(int i =0;i<M;i++) {
			st=  new StringTokenizer(br.readLine());
			int num = stoi(st.nextToken());
			int num2 = stoi(st.nextToken());
			int num3 = stoi(st.nextToken());
			pq.offer(new Node14950(num,num2,num3));
		}
		int sum=0;
		System.out.println(sum);
		int cnt=0;
		while(!pq.isEmpty()) {
			Node14950 n = pq.poll();
			int s =n.start;
			int e=n.end;
			int d=n.dist;
			int a= find(s);
			int b= find(e);
			if(a==b) {
				continue;
			}
			union(s,e);
			sum+=d+t*cnt;
			cnt++;
		}
		System.out.println(sum);
	}
}
