import java.util.*;
import java.io.*;

public class Baek11048 {
	static int[][] arr;
	static int N;
	static int M;
	static int[][] dp;
	static int[] dx = { 1, 0, 1 };
	static int[] dy = { 0, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0, 0));
	}

	public static int dfs(int x, int y) {
		if (x == N - 1 && y == M - 1) {
			return arr[0][0];
		}

		if (dp[x][y] != -1)
			return dp[x][y];
		dp[x][y] = 0;
//		print();
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isPossible(nx, ny)) {
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + arr[nx][ny]);
			}

		}
		return dp[x][y];
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dp[i][j] == -1) {
					System.out.print("0 ");
				} else
					System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M) {
			return false;
		}

		return true;
	}
}
