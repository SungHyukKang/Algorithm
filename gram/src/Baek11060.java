import java.util.*;
import java.io.*;

public class Baek11060 {
	static int N;
	static int[] arr;
	static int[] dp;
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
//		if (N == 1) {
//			System.out.println(0);
//			return;
//		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N + 1];
		Arrays.fill(dp, -1);
		System.out.println(dfs(0) == INF ? -1 : dp[0]);
	}

	public static int dfs(int idx) {
		if (idx == N - 1) {
			dp[idx] = 0;
			return 0;
		}

		if (dp[idx] != -1)
			return dp[idx];
		dp[idx] = INF;

		for (int i = 1; i <= arr[idx]; i++) {
			if (i + idx < N) {
				dp[idx] = Math.min(dp[idx], dfs(i + idx) + 1);
			}
		}

		return dp[idx];
	}

}
