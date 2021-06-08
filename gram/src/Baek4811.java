import java.util.*;
import java.io.*;

public class Baek4811 {
	static int N;
	static long[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			N = Integer.parseInt(br.readLine());
			dp = new long[2 * N + 1][31][31];
			if (N == 0)
				break;
			for (int i = 0; i < 2 * N + 1; i++) {
				for (int j = 0; j < 31; j++) {
					Arrays.fill(dp[i][j], -1);
				}
			}

			sb.append(dfs(2, N - 1, 1) + "\n");
		}
		System.out.println(sb);
	}

	public static long dfs(int n, int W, int H) {
		if (n == 2 * N) {
			return 1;
		}

		if (dp[n][W][H] != -1)
			return dp[n][W][H];

		dp[n][W][H] = 0;
		if (W > 0) {
			dp[n][W][H] += dfs(n + 1, W - 1, H + 1);
		}
		if (H > 0) {
			dp[n][W][H] += dfs(n + 1, W, H - 1);
		}
		return dp[n][W][H];

	}

}
