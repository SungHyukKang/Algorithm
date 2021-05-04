import java.util.*;
import java.io.*;

public class Baek9084 {
	static int N;
	static int M;
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dp = new int[21][10001];
			for (int i = 0; i < 21; i++)
				Arrays.fill(dp[i], -1);
			M = Integer.parseInt(br.readLine());

			sb.append(dfs(0, M) + "\n");
		}
		System.out.println(sb);
	}

	public static int dfs(int idx, int target) {
		if (target == 0)
			return 1;
		if (target < 0)
			return 0;
		if (dp[idx][target] != -1)
			return dp[idx][target];

		dp[idx][target] = 0;

		for (int i = idx; i < N; i++) {
			dp[idx][target] += dfs(i, target - arr[i]);
		}
		return dp[idx][target];
	}

}
