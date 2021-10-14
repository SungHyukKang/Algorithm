import java.util.*;
import java.io.*;

public class Baek22869 {
	static int N;
	static int K;
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		dp = new int[5001][1001];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < 5001; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(dfs(1, 0) == N ? "YES" : "NO");
	}

	public static int dfs(int depth, int k) {
		if (depth == N) {
			return N;
		}
		if (dp[depth][k] != -1)
			return dp[depth][k];
		dp[depth][k] = 0;

		for (int i = depth + 1; i <= N; i++) {
			if (i - depth > K)
				break;
			if ((i - depth) * (1 + Math.abs(arr[depth] - arr[i])) <= K) {
				dp[depth][k] = Math.max(dp[depth][k], dfs(i, (i - depth) * (1 + Math.abs(arr[depth] - arr[i]))));
			}
		}

		return dp[depth][k];

	}

}
