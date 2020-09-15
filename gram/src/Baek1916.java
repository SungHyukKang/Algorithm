import java.util.*;
import java.io.*;
public class Baek1916 {
	static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
	static boolean[] visited;
	static final int INF=2100000000;
	static int[] D;
	static int start;
	static int end;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M= Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		D=new int[N+1];
		for(int i =0;i<=N;i++) {
			arr.add(new ArrayList<Node>());
		}
		for(int i =1;i<=N;i++) {
			D[i]=INF;
		}
		StringTokenizer st;
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num= Integer.parseInt(st.nextToken());
			int num2= Integer.parseInt(st.nextToken());
			int num3= Integer.parseInt(st.nextToken());
			arr.get(num).add(new Node(num2,num3));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		System.out.println(D[end]);
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		D[start]=0;
		while(!pq.isEmpty()) {
			Node node =pq.poll();
			int index = node.index;
			int dist = node.dist;
			if(dist>D[index])
				continue;
			for(Node n : arr.get(index)) {
				if(!visited[n.index]&&D[n.index]>D[index]+n.dist) {
					D[n.index]=D[index]+n.dist;
					pq.offer(new Node(n.index,D[n.index]));
				}
			}
		}
	}
	
}
