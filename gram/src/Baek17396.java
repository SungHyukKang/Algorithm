import java.util.*;
import java.io.*;

class Node17396 implements Comparable<Node17396>{
	int index;
	long dist;
	
	Node17396(int index ,long dist){
		this.index=index;
		this.dist=dist;
	}

	@Override
	public int compareTo(Node17396 arg0) {
		return this.dist<=arg0.dist ? -1 : 1;
	}
}

public class Baek17396 {
	
	static int N;
	static int M;
	static ArrayList<ArrayList<Node17396>> arr =new ArrayList<>();
	static boolean[] possible;
	static long[] D;
	static final long INF = (long) (Long.MAX_VALUE*0.1);
	public static int stoi(String X ) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		System.out.println(INF);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		possible=new boolean[N];
		D=new long[N];
		st=new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			int num = stoi(st.nextToken());
			if(num==0||i==N-1) {
				possible[i]=true;
			}else
				possible[i]=false;
			arr.add(new ArrayList<Node17396>());
			D[i]=INF;
		}
		for(int i =0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int num = stoi(st.nextToken());
			int num2 = stoi(st.nextToken());
			int num3 = stoi(st.nextToken());
			arr.get(num).add(new Node17396(num2,num3));
			arr.get(num2).add(new Node17396(num,num3));
		}
		dijkstra();
		if(D[N-1]==INF) {
			System.out.println(-1);
		}else
			System.out.println(D[N-1]);
	}
	
	
	public static void dijkstra() {
		PriorityQueue<Node17396> pq = new PriorityQueue<Node17396>();
		pq.offer(new Node17396(0,0));
		D[0]=0;
		while(!pq.isEmpty()) {
			Node17396 node = pq.poll();
			int index =node.index;
			long dist = node.dist;
			if(dist>D[index]) {
				continue;
			}
			for(Node17396 n : arr.get(index)) {
				if(possible[n.index]&&D[n.index]>n.dist+D[index]) {
					D[n.index]=n.dist+D[index];
					pq.offer(new Node17396(n.index,D[n.index]));
				}
			}
			
		}
	}
}
