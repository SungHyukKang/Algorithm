import java.io.*;
import java.util.Arrays;

public class Baek1699 {
	static int[] dp;
	static int[] arr;
	static final int INF = 98765321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new int[100001];
		int N = Integer.parseInt(br.readLine());

		arr = new int[(int) Math.sqrt(N)];
		Arrays.fill(dp, -1);
		System.out.println(dfs(N));
	}

	public static int dfs(int target) {
		if (target == 0)
			return 0;
		if (target < 0)
			return INF;
		if (dp[target] != -1)
			return dp[target];
		dp[target] = INF;

		for (int i = 1; i <= (int) Math.sqrt(target); i++) {
			dp[target] = Math.min(dp[target], dfs(target - i * i) + 1);
		}

		return dp[target];
	}

}
