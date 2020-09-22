import java.util.*;
import java.io.*;
public class Baek11779 {
	static int N;
	static int M;
	static ArrayList<ArrayList<Node>> arr =new ArrayList<>();
	static int[] D;
	static int[] path;
	static int end;
	static final int INF =9999;
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N =stoi(br.readLine());
		M= stoi(br.readLine());
		path = new int[N+1];
		D=new int[N+1];
		for(int i =0;i<=N;i++) {
			arr.add(new ArrayList<Node>());
			D[i]=INF;
		}
		for(int i =0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int num=stoi(st.nextToken());
			int num2=stoi(st.nextToken());
			int num3=stoi(st.nextToken());
			arr.get(num).add(new Node(num2,num3));
		}
		st =new StringTokenizer(br.readLine());
		int start =stoi(st.nextToken());
		end =stoi(st.nextToken());
		dijkstra(start);
		System.out.println(D[end]);
		ArrayList<Integer> list = new ArrayList<>();
		list.add(end);
		int cnt =1;
		for(int i =end;i!=start;i=path[i]) {
			list.add(path[i]);
			cnt++;
		}
		System.out.println(cnt);
		Collections.reverse(list);
		for(int x : list) {
			System.out.print(x+" ");
		}
	}
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start,0));
		D[start]=0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int index =node.index;
			int dist=  node.dist;
			if(dist>D[index])
				continue;
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
