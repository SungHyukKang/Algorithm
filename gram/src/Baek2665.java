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


public class Baek2665 {
	static int N;
	static int[][] arr;
	static int[][] D;
	static final int INF =999;
	static int[] nx= {0,0,1,-1};
	static int[] ny= {1,-1,0,0};
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		arr=new int[N][N];
		D=new int[N][N];
		for(int i =0;i<N;i++) {
			String X = br.readLine();
			int j =0;
			for(String Z : X.split("")) {
				arr[i][j]=stoi(Z);
				D[i][j]=INF;
				j++;
			}
		}
		dijkstra();
		System.out.println(D[N-1][N-1]);
		
	}
	public static void dijkstra() {
		PriorityQueue<Node3> pq =new PriorityQueue<>();
		pq.offer(new Node3(0,0,0));
		D[0][0]=0;
		while(!pq.isEmpty()) {
			Node3 node = pq.poll();
			int x = node.i;
			int y = node.j;
			for(int i =0;i<nx.length;i++) {
				if(isPossible(x+nx[i],y+ny[i])) {
					if(arr[x+nx[i]][y+ny[i]]==0) {
						if(D[x+nx[i]][y+ny[i]]>D[x][y]+1) {
							D[x+nx[i]][y+ny[i]]=D[x][y]+1;
							pq.offer(new Node3(x+nx[i],y+ny[i],D[x+nx[i]][y+ny[i]]));
						}
					}else {
						if(D[x+nx[i]][y+ny[i]]>D[x][y]) {
							D[x+nx[i]][y+ny[i]]=D[x][y];
							pq.offer(new Node3(x+nx[i],y+ny[i],D[x+nx[i]][y+ny[i]]));
						}
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
