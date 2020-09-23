import java.util.*;
import java.io.*;

class Min implements Comparable<Min>{
	int start ;
	int end;
	int dist;
	
	Min(int s , int e , int d){
		this.start=s;
		this.end=e;
		this.dist=d;
	}

	@Override
	public int compareTo(Min arg0) {
		return this.dist<=arg0.dist ? -1 : 1;
	}
}

public class Baek1922 {
	static int N;
	static int M;
	static int parent[];
	static PriorityQueue<Min> pq = new PriorityQueue<>();
	static int stoi(String X ) {return Integer.parseInt(X);}
	static int find(int a) {
		if(parent[a]==a)
			return a;
		parent[a]=find(parent[a]);
		return parent[a];
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
		N = stoi(br.readLine());
		M = stoi(br.readLine());
		StringTokenizer st ;
		parent = new int[N+1];
		for(int i =0;i<=N;i++) {
			parent[i]=i;
		}
		for(int i =0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int num= stoi(st.nextToken());
			int num2= stoi(st.nextToken());
			int num3= stoi(st.nextToken());
			pq.offer(new Min(num,num2,num3));
		}
		int sum=0;
		for(int i =0;i<M;i++) {
			Min min = pq.poll();
			int start =min.start;
			int end =min.end;
			int dist = min.dist;
			int a = find(start);
			int b = find(end);
			if(a==b)
				continue;
			union(start,end);
			sum+=dist;
		}
		System.out.println(sum);
	}
}
