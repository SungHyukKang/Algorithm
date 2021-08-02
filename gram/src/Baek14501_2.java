import java.util.*;
import java.io.*;

public class Baek14501_2 {
	static int N;
	static int[][] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int wei = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			arr[i][0] = wei;
			arr[i][1] = val;
		}

		Arrays.fill(dp, -1);
		System.out.println(dfs(0));
	}

	public static int dfs(int n) {
		if (n > N) {
			return -1;
		}
		if (n == N) {
			return 0;
		}

		if (dp[n] != -1)
			return dp[n];
		if (n + arr[n][0] <= N)
			dp[n] = Math.max(dfs(n + 1), dfs(n + arr[n][0]) + arr[n][1]);
		else
			return dfs(n + 1);
		return dp[n];
	}

}
