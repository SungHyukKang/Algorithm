import java.util.*;
import java.io.*;
//class Node implements Comparable<Node>{
//	int index ;
//	int dist;
//	Node(int index , int dist){
//		this.index=index;
//		this.dist=dist;
//	}
//	@Override
//	public int compareTo(Node arg0) {
//		return this.dist<=arg0.dist ? -1 : 1;
//	}
//}

public class Baek1504 {
	static int N;
	static int E;
	static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
	static int[] D;
	static final int INF = 999999;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		D=new int[N+1];
		for(int i =0;i<=N;i++) {
			arr.add(new ArrayList<Node>());
			D[i]=INF;
		}
		for(int i =0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			arr.get(num).add(new Node(num2,num3));
			arr.get(num2).add(new Node(num,num3));
		}
		st = new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		int sum=0;	
		int sum2=0;	
		dijkstra(1);
		sum+=D[start];
		sum2+=D[end];
		for(int i =0;i<=N;i++) {
			D[i]=INF;
		}
		dijkstra(start);
		sum+=D[end];
		sum2+=D[N];
		for(int i =0;i<=N;i++) {
			D[i]=INF;
		}
		dijkstra(end);
		sum2+=D[start];
		sum+=D[N];
		for(int i =0;i<=N;i++) {
			D[i]=INF;
		}
		int answer =Math.min(sum,sum2);
		if(answer<=0||answer>=INF) {
			answer=-1;
		}
		System.out.println(answer);
		
	}
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		D[start]=0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int index = n.index;
			int dist =  n.dist;
			if(dist>D[index]) {
				continue;
			}
			
			for(Node node : arr.get(index)) {
				if(D[node.index]>node.dist+D[index]) {
					D[node.index]=node.dist+D[index];
					pq.offer(new Node(node.index,D[node.index]));
				}
			}
		}
	}
}
