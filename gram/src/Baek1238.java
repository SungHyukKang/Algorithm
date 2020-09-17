import java.util.*;
import java.io.*;

public class Baek1238 {
	static int N;
	static int M;
	static int X;
	static ArrayList<ArrayList<Node>> arr =new ArrayList<>();
	static HashMap<Integer,Integer> hsmapgo = new HashMap<>();
	static HashMap<Integer,Integer> hsmapback = new HashMap<>();
	static int[] go;
	static int[] back;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		go=new int[N+1];
		back=new int[N+1];
		for(int i =0;i<=N;i++) {
			arr.add(new ArrayList<Node>());
			go[i]=INF;
			back[i]=INF;
		}
		
		for(int i =0; i<M;i++) {
			st =  new StringTokenizer(br.readLine());
			int num =Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			arr.get(num).add(new Node(num2,num3));
		}
		for(int i =1;i<=N;i++) {
			dijkstra(i);
		
		}
		dijkstra2();
		int max = 0;
		for(int i=1;i<=N;i++) {
			if(max<(hsmapgo.get(i)+hsmapback.get(i))) {
				max=hsmapgo.get(i)+hsmapback.get(i);
			}
		}
		System.out.println(max);
		
	}
	public static void dijkstra(int start) {
		int[] resetGo=new int[N+1];
		for(int i =0;i<=N;i++) {
			resetGo[i]=go[i];
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		resetGo[start]=0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int index =node.index;
			int dist = node.dist;
			if(dist>resetGo[index]) {
				continue;
			}
			for(Node n : arr.get(index)) {
				if(resetGo[n.index]>n.dist+resetGo[index]) {
					resetGo[n.index]=n.dist+resetGo[index];
					pq.offer(new Node(n.index,resetGo[n.index]));
				}
			}
		}
		hsmapgo.put(start,resetGo[X]);
		
	}
	public static void dijkstra2() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(X,0));
		back[X]=0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int index =node.index;
			int dist = node.dist;
			if(dist>back[index]) {
				continue;
			}
			for(Node n : arr.get(index)) {
				if(back[n.index]>n.dist+back[index]) {
					back[n.index]=n.dist+back[index];
					pq.offer(new Node(n.index,back[n.index]));
				}
			}
		}
		for(int i =1;i<=N;i++)
		hsmapback.put(i,back[i]);
	}
}