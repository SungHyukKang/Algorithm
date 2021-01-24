import java.util.*;
import java.io.*;

public class Bael14500 {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] cx= {{0,1,2,1},{0,1,2,1},{0,0,0,-1},{0,0,0,1}};
	static int[][] cy= {{0,0,0,1},{0,0,0,-1},{0,1,2,1},{0,1,2,1}};
	static int max=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				visited[i][j]=true;
				dfs(0,0,i,j);
				visited[i][j]=false;
				fy(i,j);
			}
		}
		
		
		System.out.println(max);
	}
	public static void fy(int x, int y) {
		for(int i =0;i<4;i++) {
			int sum=0;
			int cnt=0;
			for(int j=0;j<4;j++) {
				int dx=cx[i][j]+x;
				int dy= cy[i][j]+y;
				if(isPossible(dx,dy)) {
					sum+=arr[dx][dy];
					cnt++;
				}
			}
			if(cnt==4) {
				max=Math.max(max, sum);
			}
		}
	}
	public static void dfs(int cnt, int sum,int x, int y) {
		if (cnt == 4) {
			max=Math.max(max, sum);
			return;
		}

		for (int i = 0; i < dx.length; i++) {
			int nx = x+dx[i];
			int ny= y+dy[i];
			if(isPossible(nx,ny)&&!visited[nx][ny]) {
				visited[nx][ny]=true;
				dfs(cnt+1,sum+arr[nx][ny],nx,ny);
				visited[nx][ny]=false;
			}
		}
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return false;
		return true;
	}

}
