import java.util.*;
import java.io.*;

class Node2887p implements Comparable<Node2887p>{
	int s,e,d;
	
	Node2887p(int s, int e, int d){
		this.s=s;
		this.e=e;
		this.d=d;
	}

	@Override
	public int compareTo(Node2887p arg0) {
		return this.d<=arg0.d ? -1 : 1;
	}
	
	
}

 class Node2887{
	int idx,x,y,z;
	
	public Node2887(int i,int x, int y, int z) {
		this.idx=i;
		this.x=x;
		this.y=y;
		this.z=z;
	}
}

 
public class Baek2887 {
	static int find(int s) {
		if(parent[s]==s)
			return s;
		parent[s]=find(parent[s]);
		return parent[s];
	}
	
	static void union(int a , int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot!=bRoot)
			parent[aRoot]=b;
		else
			return;
	}
	
	public static int[] parent;
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Node2887p> pq = new PriorityQueue<>();
		int N = stoi(st.nextToken());
		parent=new int[N];
		for(int i =0;i<N;i++)
			parent[i]=i;
		Node2887[] node = new Node2887[N];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int num=stoi(st.nextToken());
			int num2=stoi(st.nextToken());
			int num3=stoi(st.nextToken());
			node[i]=new Node2887(i,num,num2,num3);
		}
		Arrays.sort(node , new Comparator<Node2887>(){
			@Override
			public int compare(Node2887 arg0, Node2887 arg1) {
					if(arg0.x>arg1.x) {
						return 1;
					}else
						return -1;
			}
		});
		for(int i =0;i<node.length-1;i++) {
			pq.offer(new Node2887p(node[i].idx,node[i+1].idx,Math.abs(node[i].x-node[i+1].x)));
		}
		
		Arrays.sort(node , new Comparator<Node2887>(){
			@Override
			public int compare(Node2887 arg0, Node2887 arg1) {
					if(arg0.y>arg1.y) {
						return 1;
					}else
						return -1;
			}
		});
		for(int i =0;i<node.length-1;i++) {
			pq.offer(new Node2887p(node[i].idx,node[i+1].idx,Math.abs(node[i].y-node[i+1].y)));
		}
		Arrays.sort(node , new Comparator<Node2887>(){
			@Override
			public int compare(Node2887 arg0, Node2887 arg1) {
					if(arg0.z>arg1.z) {
						return 1;
					}else
						return -1;
			}
		});
		for(int i =0;i<node.length-1;i++) {
			pq.offer(new Node2887p(node[i].idx,node[i+1].idx,Math.abs(node[i].z-node[i+1].z)));
		}
		int sum =0;
		while(!pq.isEmpty()) {
			Node2887p n = pq.poll();
			int s = n.s;
			int e = n.e;
			int d = n.d;
			
			int a = find(s);
			int b = find(e);
			
			if(a==b) {
				continue;
			}
			union(Math.min(s,e),Math.max(s, e));
			
			sum+=d;
		}
		System.out.println(sum);
	}
}
