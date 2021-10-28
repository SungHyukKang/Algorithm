import java.util.*;
import java.io.*;

public class Baek13302 {
	static int N;
	static int M;
	static int[][] dp;
	static boolean[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new boolean[110];
		if (M > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arr[Integer.parseInt(st.nextToken())] = true;
			}
		}
		dp = new int[110][1000];
		for (int i = 0; i <= 109; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(dfs(0, 0));
	}

	public static int dfs(int depth, int coupon) {
		if (depth >= N) {
			return 0;
		}
		if (dp[depth][coupon] != -1)
			return dp[depth][coupon];
		dp[depth][coupon] = Integer.MAX_VALUE;
		if (arr[depth + 1]) {
			dp[depth][coupon] = Math.min(dp[depth][coupon], dfs(depth + 1, coupon));
		} else {
			if (coupon >= 3) {
				dp[depth][coupon] = Math.min(dp[depth][coupon], dfs(depth + 1, coupon - 3));
			}
			dp[depth][coupon] = Math.min(dp[depth][coupon], dfs(depth + 1, coupon) + 10000);
			dp[depth][coupon] = Math.min(dp[depth][coupon], dfs(depth + 3, coupon + 1) + 25000);
			dp[depth][coupon] = Math.min(dp[depth][coupon], dfs(depth + 5, coupon + 2) + 37000);
		}
		return dp[depth][coupon];
	}

}
