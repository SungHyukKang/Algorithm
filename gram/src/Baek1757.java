import java.util.*;
import java.io.*;

public class Baek1757 {
	static int N;
	static int M;
	static int[][] dp;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp = new int[10001][501];
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(dfs(0, 0));
	}

	public static int dfs(int n, int m) {
		if (N == n) {
			return 0;
		}
		if (dp[n][m] != -1)
			return dp[n][m];
		dp[n][m] = 0;
		if (m < M && N - n - 1 > m) {
			dp[n][m] = Math.max(dp[n][m], dfs(n + 1, m + 1) + arr[n]);
		}
		if (m == 0)
			dp[n][m] = Math.max(dp[n][m], dfs(n + 1, m));
		else {
			dp[n][m] = Math.max(dp[n][m], dfs(n + m, 0));

		}

		return dp[n][m];
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(dp[i][j] == -1 ? "0 " : dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}
}