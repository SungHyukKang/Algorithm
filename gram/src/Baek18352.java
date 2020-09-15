import java.io.*;
import java.util.*;
public class Baek18352 {
	static int N;
	static int M;
	static int K;
	static int X;
	public static final int INF=2100000000;
	public static ArrayList<ArrayList<Node>> arr=new ArrayList<>();
	public static int[] D;
	public static boolean[] visited;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		D = new int[N+1];
		visited= new boolean[N+1];
		for(int i =0;i<=N;i++) {
			arr.add(new ArrayList<Node>());
		}
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num =Integer.parseInt(st.nextToken());
			int num2 =Integer.parseInt(st.nextToken());
			arr.get(num).add(new Node(num2,1));
		}
		for(int i =1;i<=N;i++) {
			D[i]=INF;
		}
		dijkstra(X);
		boolean tf=true;
		for(int i =1;i<=N;i++) {
			if(D[i]==K) {
				System.out.println(i);
				tf=false;
			}
		}
		if(tf) {
			System.out.println("-1");
		}
	}
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start,0));
		D[start]=0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int idx=node.index;
			int dist= node.dist;
			if(dist>D[idx]) {
				continue;
			}
			for(Node n : arr.get(idx)) {
				if(!visited[n.index]&&D[n.index]>n.dist+D[idx]) {
					D[n.index]=n.dist+D[idx];
					visited[n.index]=true;
					pq.add(new Node(n.index,D[n.index]));
				}
			}
		}
	}
}
