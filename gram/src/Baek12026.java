import java.util.*;
import java.io.*;

public class Baek12026 {
	static final int INF = 987654321;
	static int[] dp;
	static char[] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		dp = new int[N + 1];
		Arrays.fill(dp, -1);
		System.out.println(dfs(0, 'B') == INF ? -1 : dp[0]);
	}

	public static int dfs(int idx, char ch) {
		if (idx == N - 1) {
			return 0;
		}
		if (dp[idx] != -1)
			return dp[idx];
		dp[idx] = INF;
		if (ch == 'B') {
			for (int i = idx + 1; i < N; i++) {
				if (arr[i] == 'O')
					dp[idx] = Math.min(dp[idx], dfs(i, 'O') + (i - idx) * (i - idx));
			}

		} else if (ch == 'O') {
			for (int i = idx + 1; i < N; i++) {
				if (arr[i] == 'J')
					dp[idx] = Math.min(dp[idx], dfs(i, 'J') + (i - idx) * (i - idx));
			}
		} else {
			for (int i = idx + 1; i < N; i++) {
				if (arr[i] == 'B')
					dp[idx] = Math.min(dp[idx], dfs(i, 'B') + (i - idx) * (i - idx));
			}
		}
		return dp[idx];
	}

	public static void print(int[][] dp) {

	}

}
