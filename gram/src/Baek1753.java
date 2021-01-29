import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int index ;
	int dist;
	Node(int index , int dist){
		this.index=index;
		this.dist=dist;
	}
	@Override
	public int compareTo(Node arg0) {
		return this.dist<=arg0.dist ? -1 : 1;
	}
}
public class Baek1753 {
	public static int V;
	public static int E;
	public static ArrayList<ArrayList<Node>> arr;
	public static int[] D;
	public static boolean[] visited;
	public static final int INF =1000000000;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		D= new int[V+1];
		arr = new ArrayList<>();
		for(int i=0;i<=V;i++) {
			arr.add(new ArrayList<Node>());
		}
		int start =Integer.parseInt(br.readLine());
		for(int i =0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int num2 =Integer.parseInt(st.nextToken());
			int num3 =Integer.parseInt(st.nextToken());
			arr.get(num).add(new Node(num2,num3));
		}
		
		for(int i =1;i<=V;i++) {
			D[i]=INF;
		}
		dijkstra(start);
		for(int i =1;i<=V;i++) {
			if(D[i]==INF)
				bw.write("INF\n");
			else
				bw.write(D[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start,0));
		D[start]=0;
		while(!pq.isEmpty()) {
			int index = pq.peek().index;
			int dist =-pq.peek().dist;
			pq.poll();
//			if(dist>D[index]) {
//				continue;
//			}
			for(Node node : arr.get(index)) {
				if(D[node.index]>node.dist+D[index]){
					D[node.index]=node.dist+D[index];
					pq.add(new Node(node.index,-D[node.index]));
				}
			}
			
		}
		
	}
}
//import java.util.*;
//public class Baek1753 {
//	public static int V;
//	public static int E;
//	public static int[][]arr;
//	public static int[] D;
//	public static boolean[] visited;
//	public static final int INF =1000000000;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		V = sc.nextInt();
//		E = sc.nextInt();
//		arr=new int[V+1][V+1];
//		int start = sc.nextInt();
//		visited = new boolean[V+1];
//		D=new int[V+1];
//		for(int i = 0;i<E;i++) {
//			int num1 = sc.nextInt();
//			int num2 = sc.nextInt();
//			arr[num1][num2]= sc.nextInt();
//		}
//		for(int i = 1;i<=V;i++) {
//			for(int j =1;j<=V;j++) {
//				if(arr[i][j]==0&&i!=j) {
//					arr[i][j]=INF;
//				}
//			}
//		}
//		print();
//		dijkstra(start);
//		for(int i =1;i<D.length;i++) {
//			if(D[i]==INF) {
//				System.out.println("INF");
//			}else
//				System.out.println(D[i]);
//		}
//		
//	}
//	public static void dijkstra(int start) {
//			for(int i =1;i<=V;i++) {
//				D[i]=arr[start][i];
//			}
//			visited[start]=true;
//			for(int i=1;i<=V;i++) {
//				int cur = getSmallIndex();
//				visited[cur]=true;
//				for(int j =1;j<=V;j++) {
//					if(!visited[j]) {
//						if(D[cur]+arr[cur][j]<D[j]) {
//							D[j]=D[cur]+arr[cur][j];
//						}
//						print();
//					}
//				}
//			}
//	}
//	
//	public static void print() {
//		for(int i =1;i<=V;i++) {
//				if(D[i]==INF) {
//					System.out.print("INF ");
//				}else
//					System.out.print(D[i]+" ");
//		}
//		System.out.println();
//		System.out.println("-------------------------");
//	}
//	
//	public static int getSmallIndex() {
//		int min = INF;
//		int index=1;
//		for(int i =1;i<=V;i++) {
//			if(D[i]<min&&!visited[i]) {
//				min=D[i];
//				index = i;
//			}
//		}
//		return index;
//	}
//	
//}
