import java.util.*;
import java.io.*;

public class Baek16568 {
	static int N;
	static int a;
	static int b;

	static int[] dp;
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		dp = new int[N + 1];
		Arrays.fill(dp, INF);
		System.out.println(dfs(N));
	}

	public static int dfs(int n) {
		if (n == 0)
			return 0;
		if (n < 0)
			return INF;
		if (dp[n] != INF)
			return dp[n];

		dp[n] = Math.min(dp[n], dfs(n - 1) + 1);
		if (n - 1 - a >= 0)
			dp[n] = Math.min(dp[n], dfs(n - 1 - a) + 1);
		if (n - 1 - b >= 0)
			dp[n] = Math.min(dp[n], dfs(n - 1 - b) + 1);

		return dp[n];
	}

}
