import java.util.*;
import java.io.*;

public class Baek1890 {
	static int N;
	static int[][] arr;
	static long[][] dp;
	static int[] nx = { 0, 1 };
	static int[] ny = { 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new long[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0, 0));
	}

	public static long dfs(int x, int y) {
		if (x == N - 1 && y == N - 1) {
			return 1;
		}

		if (dp[x][y] != -1)
			return dp[x][y];
		dp[x][y] = 0;
		for (int i = 0; i < 2; i++) {
			int dx = nx[i] * arr[x][y] + x;
			int dy = ny[i] * arr[x][y] + y;
			if (isPossible(dx, dy)) {
				dp[x][y] += dfs(dx, dy);
			}
		}

		return dp[x][y];
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) {
			return false;
		}
		return true;
	}
}
