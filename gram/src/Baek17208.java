import java.util.*;
import java.io.*;

public class Baek17208 {
	static int N;
	static int M;
	static int K;

	static int[][][] dp;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N][M + 1][K + 1];
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			arr[i][0] = m;
			arr[i][1] = k;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= M; j++)
				Arrays.fill(dp[i][j], -1);
		}
		System.out.println(dfs(0, 0, 0));
		for (int i = 0; i < N; i++) {

		}

	}

	public static int dfs(int n, int m, int k) {

		if (n == N)
			return 0;

		if (dp[n][m][k] != -1)
			return dp[n][m][k];
		dp[n][m][k] = 0;
		if (m + arr[n][0] <= M && k + arr[n][1] <= K) {
			dp[n][m][k] = Math.max(dp[n][m][k], dfs(n + 1, m + arr[n][0], k + arr[n][1]) + 1);
		}
		dp[n][m][k] = Math.max(dp[n][m][k], dfs(n + 1, m, k));

		return dp[n][m][k];
	}

}
