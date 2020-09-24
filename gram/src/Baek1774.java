import java.util.*;
import java.io.*;

class Location{
	int x,y;
	
	
	Location(int x,int y){
		this.x=x;
		this.y=y;
		
	}
}

class Node1774 implements Comparable<Node1774>{
	int start;
	int end;
	double dist;
	
	Node1774(int s ,int e, double d){
		this.start=s;
		this.end=e;
		this.dist=d;
	}

	@Override
	public int compareTo(Node1774 o) {
		return this.dist<=o.dist ? -1 : 1;
	}
	
}
public class Baek1774 {
	static int N;
	static int M;
	static int[] parent;
	static PriorityQueue<Node1774> pq  =new PriorityQueue<>();
	public static int stoi(String X) {return Integer.parseInt(X);}
	
	public static int find(int a) {
		if(parent[a]==a) {
			return a;
		}
		parent[a]=find(parent[a]);
		return parent[a];
	}
	
	public static void union(int a , int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		if(aRoot!=bRoot) {
			parent[aRoot]=b;
		}else
			return;
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		parent = new int[N];
		for(int i =0;i<N;i++) {
			parent[i]=i;
		}
		Location[] loc = new Location[N];
		for(int i =0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			int num =stoi(st.nextToken());
			int num2 =stoi(st.nextToken());
			loc[i]=new Location(num,num2);
		}
		for(int i =0;i<M;i++) {
			st= new StringTokenizer(br.readLine());
			int num =stoi(st.nextToken())-1;
			int num2 =stoi(st.nextToken())-1;
			int a =find(num);
			int b =find(num2);
			if(a==b)
				continue;
			union(num,num2);
		}
		
		double sum=0;
		for(int i =0;i<N;i++) {
			for(int j =i;j<N;j++) {
				if(i==j)
					continue;
				int x=loc[i].x-loc[j].x;
				int y=loc[i].y-loc[j].y;
				pq.offer(new Node1774(i , j , distance(x,y)));
			}
		}
		while(!pq.isEmpty()) {
			Node1774 node = pq.poll();
			int start =node.start;
			int end =node.end;
			double dist = node.dist;
			int a = find(start);
			int b = find(end);
			if(a==b)
				continue;
			union(start,end);
			sum+=dist;
		}
		System.out.println(String.format("%.2f", sum));
		
	}
	
	public static double distance(int x, int y) {
		long xx =(long) Math.pow(x, 2);
		long yy =(long) Math.pow(y, 2);
		double dist = Math.sqrt(xx+yy);
		return dist;
	}
}
