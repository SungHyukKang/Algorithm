import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Baek2624 {
	static int T, K;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new int[K][2];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[i] = new int[] { m, c };
		}
		dp = new int[K][T + 1];
		for (int i = 0; i < K; i++)
			Arrays.fill(dp[i], -1);
		System.out.println(dfs(0, 0));
	}

	public static int dfs(int depth, int sum) {
		if (sum > T) {
			return 0;
		}
		if (sum == T) {
			return 1;
		}
		if (depth == K) {
			if (sum == T) {
				return 1;
			}
			return 0;
		}
		if (dp[depth][sum] != -1) {
			return dp[depth][sum];
		}
		dp[depth][sum] = 0;
		for (int i = 0; i <= arr[depth][1]; i++) {
			dp[depth][sum] += dfs(depth + 1, sum + arr[depth][0] * i);
		}
		return dp[depth][sum];

	}

}
