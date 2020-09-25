import java.util.*;
import java.io.*;
class Location4386{
	double x;
	double y;
	
	public Location4386(double x,double y) {
		this.x=x;
		this.y=y;
	}
}

class Node4386 implements Comparable<Node4386>{
	int start;
	int end;
	double dist;
	
	Node4386(int s ,int e, double d){
		this.start=s;
		this.end=e;
		this.dist=d;
	}

	@Override
	public int compareTo(Node4386 o) {
		return this.dist<=o.dist ? -1 : 1;
	}
}



public class Baek4386 {
	static int N;
	static int[] parent;
	public static double stod(String X) {return Double.parseDouble(X);}
	
	static int find(int start) {
		if(parent[start]==start) {
			return start;
		}
		parent[start]=find(parent[start]);
		return parent[start];
	}
	
	static void union(int a,int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot!=bRoot) {
			parent[aRoot]=b;
		}else
			return;
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=(int)stod(br.readLine());
		parent=new int[N];
		for(int i =0;i<N;i++) {
			parent[i]=i;
		}
		
		Location4386[] loc = new Location4386[N];
		PriorityQueue<Node4386> pq = new PriorityQueue<Node4386>();
		for(int i =0;i<N;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			double num  = stod(st.nextToken());
			double num2  = stod(st.nextToken());
			loc[i]=new Location4386(num, num2);
		}
		for(int i =0;i<N;i++) {
			for(int j=i;j<N;j++) {
				if(i==j)
					continue;
				double x = loc[i].x-loc[j].x;
				double y = loc[i].y-loc[j].y;
				double dist =distance(x,y);
				pq.offer(new Node4386(i,j,dist));
			}
		}
		double sum=0;
		while(!pq.isEmpty()) {
			Node4386 node =pq.poll();
			int start  =node.start;
			int end = node.end;
			double dist =node.dist;
			int a=find(start);
			int b=find(end);
			if(a==b)
				continue;
			union(start,end);
			sum+=dist;
		}
		System.out.println(String.format("%.2f", sum));
	}

	public static double distance(double x, double y) {
		double xx = Math.pow(x, 2);
		double yy =Math.pow(y, 2);
		double dist = Math.sqrt(xx+yy);
		return dist;
	}
	
	
}
