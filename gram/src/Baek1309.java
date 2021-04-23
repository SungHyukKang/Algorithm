import java.util.*;
import java.io.*;

public class Baek1309 {
	static int[][] dp;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(dfs(0, 0) % 9901);
	}

	public static int dfs(int x, int state) {
		if (x == N) {
			return 1;
		}

		if (dp[x][state] != -1)
			return dp[x][state];
		dp[x][state] = 0;
		dp[x][state] = (dp[x][state] + dfs(x + 1, 0)) % 9901;
		if (state != 1) {
			dp[x][state] = (dp[x][state] + dfs(x + 1, 1)) % 9901;
		}
		if (state != 2) {
			dp[x][state] = (dp[x][state] + dfs(x + 1, 2)) % 9901;
		}

		return dp[x][state];
	}
}
