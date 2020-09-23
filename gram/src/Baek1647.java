import java.util.*;
import java.io.*;
public class Baek1647 {
	static int N;
	static int M;
	static PriorityQueue<Min> pq = new PriorityQueue<Min>();
	static int[] parent;
	static int stoi(String X) { return Integer.parseInt(X);}
	
	public static int find(int a) {
		if(parent[a]==a) {
			return a;
		}
		parent[a]=find(parent[a]);
		return parent[a];
	}
	public static void union(int start , int end) {
		int sRoot = find(start);
		int eRoot = find(end);
//		System.out.println("start : "+start +" sRoot : "+sRoot);
//		System.out.println("end : "+end +"eRoot : "+eRoot);
		if(sRoot!=eRoot) {
			parent[sRoot]=end;
//			System.out.println("parent["+sRoot+"] : "+end);
		}else
			return;
		
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		parent = new int[N+1];
		for(int i =0 ;i<=N;i++) {
			parent[i]=i;
		}
		for(int i =0;i<M;i++) {
			st= new StringTokenizer(br.readLine());
			int num=stoi(st.nextToken());
			int num2=stoi(st.nextToken());
			int num3=stoi(st.nextToken());
			pq.offer(new Min(num,num2,num3));
		}
		int sum=0;
		int max=0;
		for(int i =0;i<M;i++) {
			Min m = pq.poll();
			int s=m.start;
			int e=m.end;
			int d=m.dist;
			
//			System.out.println(s+" "+e+" "+d);
			int a = find(s);
			int b = find(e);
			if(a==b)
				continue;
			union(s,e);
			sum+=d;
			if(max<d) {
				max=d;
			}
		}
		System.out.println(sum-max);
	}

}
