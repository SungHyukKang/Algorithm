import java.util.*;

import javafx.scene.layout.Priority;

import java.io.*;
public class Baek10282 {
	static int n;
	static int d;
	static int c;
	static int[] D;
	static final int INF = 2000000000;
	static int stoi(String X) {return Integer.parseInt(X);}
	static ArrayList<ArrayList<Node>> arr; 
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = stoi(br.readLine());
		for(int t=0;t<T;t++) {
			st= new StringTokenizer(br.readLine());
			arr =new ArrayList<>();
			n = stoi(st.nextToken());
			d = stoi(st.nextToken());
			c = stoi(st.nextToken());
			D=new int[n+1];
			for(int i =0;i<=n;i++) {
				arr.add(new ArrayList<Node>());
				D[i]=INF;
			}
			for(int i =0;i<d;i++) {
				st=new StringTokenizer(br.readLine());
				int num = stoi(st.nextToken());
				int num2 = stoi(st.nextToken());
				int num3 = stoi(st.nextToken());
				arr.get(num2).add(new Node(num,num3));
			}
			dijkstra(c);
			int cnt = 0;
			int max =0 ;
			for(int i =1;i<=n;i++) {
				if(D[i]!=INF)
					cnt++;
				if(D[i]!=INF&&max<D[i]) {
					max=D[i];
				}
			}
			System.out.println(cnt+" "+max);
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start,0));
		D[start]=0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int index =node.index;
			int dist = node.dist;
			if(dist>D[index]) {
				continue;
			}
			for(Node n : arr.get(index)) {
				if(D[n.index]>n.dist+D[index]) {
					D[n.index]=n.dist+D[index];
					pq.offer(new Node(n.index,D[n.index]));
				}
				
			}
			
			
		}
	}
}
