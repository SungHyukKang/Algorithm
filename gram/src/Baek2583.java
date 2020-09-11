import java.util.*;
import java.io.*;

public class Baek2583 {
	static int M;
	static int N;
	static int K;
	static int[][] arr;
	static boolean[][] visited;
	
	static Queue<Pair> q = new LinkedList<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		arr = new int[N][M];
		int section=0;
		visited = new boolean[N][M];
		for(int i =0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			for(int j =x;j<dx;j++) {
				for(int k = y;k<dy;k++) {
					arr[j][k]=1;
				}
			}
		}
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(arr[i][j]==0&&!visited[i][j]) {
					q.offer(new Pair(i,j));
					visited[i][j]=true;
					pq.offer(bfs());
					section++;
				}
			}
		}
		System.out.println(section);
		while(!pq.isEmpty())
			System.out.print(pq.poll()+" ");
		
	}

	public static int bfs() {
		int cnt =0;
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int x = pair.x;
			int y = pair.y;
			cnt++;
			if(isPossible(x+1,y)) {
				q.offer(new Pair(x+1,y));
				visited[x+1][y]=true;
			}
			if(isPossible(x-1,y)) {
				q.offer(new Pair(x-1,y));
				visited[x-1][y]=true;
			}
			if(isPossible(x,y+1)) {
				q.offer(new Pair(x,y+1));
				visited[x][y+1]=true;
			}
			if(isPossible(x,y-1)) {
				q.offer(new Pair(x,y-1));
				visited[x][y-1]=true;
			}
		}
		return cnt;
	}
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) {
			return false;
		}
		if(visited[x][y]||arr[x][y]==1)
			return false;
		return true;
	}
	public static void print() {
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}