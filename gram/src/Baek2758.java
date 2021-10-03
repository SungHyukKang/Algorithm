import java.util.*;
import java.io.*;

public class Baek2758 {
	static int N;
	static int M;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new long[2001][11];
			for (int i = 0; i <= 2000; i++) {
				Arrays.fill(dp[i], -1);
			}
			long result = 0;
			for (int i = M; i >= 1; i--) {
				result += dfs(i, 0);
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static long dfs(int M, int depth) {
		if (depth == N - 1) {
			return 1;
		}

		if (dp[M][depth] != -1)
			return dp[M][depth];
		dp[M][depth] = 0;

		for (int i = M / 2; i >= 1; i--) {
			dp[M][depth] += dfs(i, depth + 1);
		}

		return dp[M][depth];
	}

}
