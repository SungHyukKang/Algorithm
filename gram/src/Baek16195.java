import java.util.*;
import java.io.*;

public class Baek16195 {
	static int[][] dp;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new int[N + 1][M];
			for (int i = 0; i <= N; i++)
				Arrays.fill(dp[i], -1);
			sb.append(dfs(0, 0)).append("\n");
		}
		System.out.println(sb);
	}

	public static int dfs(int target, int depth) {
		if (target == N) {
			return 1;
		}
		if (depth == M) {
			return 0;
		}

		if (dp[target][depth] != -1)
			return dp[target][depth];
		
		dp[target][depth] = 0;
		
		for (int i = 1; i <= 3; i++) {
			if (target + i <= N) {
				dp[target][depth] = (dp[target][depth] + dfs(target + i, depth + 1)) % 1000000009;
			}
		}

		return dp[target][depth] % 1000000009;
	}

}
