import java.util.*;
import java.io.*;

public class Baek17404 {
	static int N;
	static int[][] arr;
	static int[][][] dp;
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[3][N][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		int one = dfs(0, 0, 0);
		int two = dfs(1, 0, 1);
		int three = dfs(2, 0, 2);
		System.out.println(Math.min(one, Math.min(two, three)));
	}

	public static int dfs(int start, int n, int color) {
		if (n == N - 1) {
			return arr[n][color];
		}
		if (dp[start][n][color] != -1)
			return dp[start][n][color];
		dp[start][n][color] = INF;

		if (N - 2 == n) {
			for (int i = 0; i < 3; i++) {
				if (i == start || i == color)
					continue;
				dp[start][n][color] = Math.min(dp[start][n][color], dfs(start, n + 1, i) + arr[n][color]);
			}
		} else {
			if (color == 0) {
				dp[start][n][color] = Math.min(dfs(start, n + 1, 1) + arr[n][color],
						dfs(start, n + 1, 2) + arr[n][color]);
			} else if (color == 1) {
				dp[start][n][color] = Math.min(dfs(start, n + 1, 0) + arr[n][color],
						dfs(start, n + 1, 2) + arr[n][color]);
			} else {
				dp[start][n][color] = Math.min(dfs(start, n + 1, 1) + arr[n][color],
						dfs(start, n + 1, 0) + arr[n][color]);
			}
		}
		return dp[start][n][color];
	}

	public static void print(int color) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dp[color][i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");

	}

}
