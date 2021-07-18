import java.util.*;
import java.io.*;

public class Baek14728 {
	static int N;
	static int T;
	static int[][] dp;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N + 1][T + 1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(dfs(1, T));
	}

	public static int dfs(int idx, int t) {
		if (idx == N) {
			if (arr[N][0] <= t) {
				return arr[N][1];
			} else
				return 0;
		}
		if (dp[idx][t] != -1)
			return dp[idx][t];

		if (t >= arr[idx][0]) {
			dp[idx][t] = Math.max(dfs(idx + 1, t), dfs(idx + 1, t - arr[idx][0]) + arr[idx][1]);
		} else {
			return dfs(idx + 1, t);
		}

		return dp[idx][t];
	}
}
