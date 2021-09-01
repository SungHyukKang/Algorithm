import java.util.*;
import java.io.*;

public class Baek14945 {
	static int N;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		dp = new int[N][N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		System.out.println(dfs(0, 0, 0));
	}

	public static int dfs(int depth, int a, int b) {
		if (depth > 0 && a == b)
			return 0;
		if (depth == N - 1) {
			return 1;
		}

		if (dp[depth][a][b] != -1)
			return dp[depth][a][b];
		dp[depth][a][b] = 0;
		dp[depth][a][b] = (dp[depth][a][b] + dfs(depth + 1, a, b)) % 10007;
		dp[depth][a][b] = (dp[depth][a][b] + dfs(depth + 1, a + 1, b)) % 10007;
		dp[depth][a][b] = (dp[depth][a][b] + dfs(depth + 1, a, b + 1)) % 10007;
		dp[depth][a][b] = (dp[depth][a][b] + dfs(depth + 1, a + 1, b + 1)) % 10007;

		return dp[depth][a][b];
	}

}
