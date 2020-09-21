import java.util.*;
import java.io.*;

class Node3 implements Comparable<Node3>{
	int i;
	int j;
	int dist;
	
	
	Node3(int i , int j ,int dist){
		this.i=i;
		this.j=j;
		this.dist=dist;
	}
	@Override
	public int compareTo(Node3 arg0) {
		return this.dist<=arg0.dist ? -1 : 1;
	}
}

public class Baek4485 {
	
	static int N;
	static int[][] arr;
	static final int INF = 99999;
	static int[][] D;
	static int[] nx= {0,0,1,-1};
	static int[] ny= {1,-1,0,0};
	public static  int stoi(String X) {
		return Integer.parseInt(X);
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t =0;
		while(true) {
		t++;
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		if(N!=0) {
			arr = new int[N][N];
			D=new int[N][N];
			for(int i =0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j =0;j<N;j++) {
					arr[i][j]=stoi(st.nextToken());
					D[i][j]=INF;
				}
			}
			dijkstra();
			System.out.println("Problem "+t+": "+D[N-1][N-1]);
		}
		}
	}
	public static void dijkstra() {
		PriorityQueue<Node3> pq = new PriorityQueue<>();
		pq.offer(new Node3(0,0,arr[0][0]));
		D[0][0]=arr[0][0];
		while(!pq.isEmpty()) {
			Node3 node = pq.poll();
			int i = node.i;
			int j = node.j;
			int dist = node.dist;
			if(dist>D[i][j]) {
				continue;
			}
			for(int x =0;x<nx.length;x++) {
				if(isPossible(i+nx[x],j+ny[x])){
					if(D[nx[x]+i][ny[x]+j]>dist+arr[nx[x]+i][ny[x]+j]) {
						D[nx[x]+i][ny[x]+j]=dist+arr[nx[x]+i][ny[x]+j];
						pq.offer(new Node3(nx[x]+i,ny[x]+j,D[nx[x]+i][ny[x]+j]));
					}
				}
			}
			
		}
	}
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=N)
			return false;
		return true;
	}
	
}
