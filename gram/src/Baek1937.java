import java.util.*;
import java.io.*;

public class Baek1937 {
	static int N;
	static int[][] arr;
	static int[][] dp;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 0;
			while (st.hasMoreTokens()) {
				String Z = st.nextToken();
				dp[i][j] = 1;
				arr[i][j++] = Integer.parseInt(Z);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.println("start!!");
				dfs(i, j);
			}
		}
		int max=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(max<dp[i][j])
					max=dp[i][j];
			}
		}
		System.out.println(max);
		
	}

	public static int dfs(int x, int y) {
		System.out.println(x + " " + y);
		print();
		if (dp[x][y] > 1) {
			return dp[x][y];
		}

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (isPossible(nx, ny) && (arr[x][y] < arr[nx][ny])) {
				System.out.println("!");
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
			}
		}
		return dp[x][y];
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		System.out.println("===================");
	}
}
