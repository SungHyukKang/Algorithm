import java.util.*;
import java.io.*;
public class Baek2589 {
	static int[][] arr;
	static int[][] arrcpy;
	static int H;
	static int W;
	static int max = 0;
	static Queue<Pair> q = new LinkedList<>();
	static boolean[][] visited;
	static boolean[][] visited2;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		arrcpy=new int[H][W];
		visited=new boolean[H][W];
		visited2=new boolean[H][W];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
		for(int i =0;i<H;i++) {
			String Z =br.readLine();
			for(int j=0;j<Z.length();j++) {
				if(Z.charAt(j)=='W') {
					arr[i][j]=-1;
					arrcpy[i][j]=-1;
				}else {
					arr[i][j]=0;
					arrcpy[i][j]=0;
				}
			}
		}
		for(int i =0;i<H;i++) {
			for(int j =0;j<W;j++) {
				if(arr[i][j]==0&&!visited2[i][j]) {
					visited=new boolean[H][W];
					q.offer(new Pair(i,j));
					visited[i][j]=true;
					visited2[i][j]=true;
					init();
					bfs();
					
			}
		}
	}
		System.out.println(max);
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int x =pair.x;
			int y= pair.y;
			if(max<arrcpy[x][y]) {
				max=arrcpy[x][y];
			}
			if(isPossible(x+1,y)) {
				q.offer(new Pair(x+1,y));
				arrcpy[x+1][y]=arrcpy[x][y]+1;
				visited[x+1][y]=true;
			}if(isPossible(x-1,y)) {
				q.offer(new Pair(x-1,y));
				arrcpy[x-1][y]=arrcpy[x][y]+1;
				visited[x-1][y]=true;
			}if(isPossible(x,y+1)) {
				q.offer(new Pair(x,y+1));
				arrcpy[x][y+1]=arrcpy[x][y]+1;
				visited[x][y+1]=true;
			}if(isPossible(x,y-1)) {
				q.offer(new Pair(x,y-1));
				arrcpy[x][y-1]=arrcpy[x][y]+1;
				visited[x][y-1]=true;
			}
		}
	}
	
	public static void init() {
		for(int i =0;i<H;i++) {
			for(int j =0;j<W;j++) {
				arrcpy[i][j]=arr[i][j];
			}
		}
	}
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=H||y<0||y>=W) {
			return false;
		}
		if(visited[x][y]||arr[x][y]==-1) {
			return false;
		}
		return true;
	}
	static void print() {
		for(int i =0;i<H;i++) {
			for(int j =0;j<W;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}	
}