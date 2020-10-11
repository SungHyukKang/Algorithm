import java.util.*;
import java.io.*;

class Node1719 implements Comparable<Node1719>{
	int index;
	int d;
	
	Node1719(int idx,int d){
		this.index=idx;
		this.d=d;
	}

	@Override
	public int compareTo(Node1719 o) {
		return this.d<=o.d ? -1 : 1;
	}
	
}

public class Baek1719 {
	static int N;
	static int M;
	static ArrayList<ArrayList<Node1719>> adjlist = new ArrayList<>();
	static int[][] D;
	static int[][] path;
	static final int INF = 987654321;
	public static int stoi(String x) {return Integer.parseInt(x);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		D=new int[N+1][N+1];
		path=new int[N+1][N+1];
		for(int i=0;i<=N;i++) {
			adjlist.add(new ArrayList<>());
		}
		for(int i =1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				if(i==j)
					continue;
				D[i][j]=INF;
			}
		}
		
		for(int i =0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int num =stoi(st.nextToken());
			int num2 =stoi(st.nextToken());
			int num3 =stoi(st.nextToken());
			adjlist.get(num).add(new Node1719(num2,num3));
			adjlist.get(num2).add(new Node1719(num,num3));
		}
		for(int i =1;i<=N;i++) {
			PriorityQueue<Node1719> pq = new PriorityQueue<>();
			pq.offer(new Node1719(i,0));
			D[i][i]=0;
			while(!pq.isEmpty()) {
				Node1719 n = pq.poll();
				int idx = n.index;
				int d=n.d;
				if(d>D[i][idx])
					continue;
				for(Node1719 nd : adjlist.get(idx)) {
					if(D[i][nd.index]>nd.d+D[i][idx]) {
						path[i][nd.index]=idx;
						D[i][nd.index]=nd.d+D[i][idx];
//						System.out.println(i+" "+nd.index+" "+D[i][nd.index]);
						pq.offer(new Node1719(nd.index,D[i][nd.index]));
					}
				}
			}
			int z =0;
			for(int j=1;j<=N;j++ ) {
				if(i==j) {
					System.out.print("- ");
					continue;
				}
				for(int k=j; k!=i;k=path[i][k]) {
					z=k;
				}
				
				System.out.print(z+" ");
			}
			System.out.println();
		}
	}
	
}
