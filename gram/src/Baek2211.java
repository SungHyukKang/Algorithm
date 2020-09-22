import java.util.*;
import java.io.*;

//class Node implements Comparable<Node>{
//	int index;
//	int dist;
//	
//	Node(int index , int dist){
//		this.index=index;
//		this.dist=dist;
//	}
//	
//	@Override
//	public int compareTo(Node arg0) {
//		return this.dist<=arg0.dist ? -1:1;
//	}
//}

public class Baek2211 {
	static int[] path;
	static int N;
	static int M;
	static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();
	static int[] D ;
	static final int INF=2100000000;
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		D=new int[N+1];
		path=new int[N+1];
		for(int i =0;i<=N;i++) {
			arr.add(new ArrayList<Node>());
			D[i]=INF;
		}
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num = stoi(st.nextToken());
			int num2 = stoi(st.nextToken());
			int num3 = stoi(st.nextToken());
			arr.get(num).add(new Node(num2,num3));
			arr.get(num2).add(new Node(num,num3));
		}
		dijkstra();
		System.out.println(N-1);
		for(int i =2;i<=N;i++) {
			System.out.println(path[i]+" "+i);
		}
		
	}
	
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1,0));
		D[1]=0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int index =node.index;
			int dist = node.dist;
			
			if(dist>D[index]){
				continue;
			}
			for(Node n : arr.get(index)) {
				if(D[n.index]>n.dist+D[index]) {
					D[n.index]=n.dist+D[index];
					path[n.index]=index;
					pq.offer(new Node(n.index,D[n.index]));
				}
			}
			
			
		}
	}
}
