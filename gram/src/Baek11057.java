import java.io.*;
import java.util.Arrays;

public class Baek11057 {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[1001][10];
		Arrays.fill(dp[1], 1);
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int z = 0; z <= j; z++) {
					dp[i][j] = dp[i][j] + dp[i - 1][z];
					dp[i][j] = dp[i][j] % 10007;
				}
			}
		}
		int answer = 0;
		for (int j = 0; j < 10; j++) {
			answer = (answer + dp[N][j]) % 10007;
		}
		System.out.println(answer);
//		for (int i = 0; i < 10; i++) {
//			ans = (ans + dfs(N, i)) % 10007;
//		}
//		System.out.println(ans);
	}

//	public static int dfs(int N, int L) {
//		if (N == 1)
//			return 1;
//		if (dp[N][L] != 0) {
//			return dp[N][L];
//		}
//		for (int i = 0; i <= L; i++) {
//			dp[N][L] = (dp[N][L] + dfs(N - 1, i)) % 10007;
//		}
//		return dp[N][L];
//	}

}
