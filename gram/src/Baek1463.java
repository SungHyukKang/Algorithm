import java.util.*;
import java.io.*;

public class Baek1463 {
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		dp = new int[X + 1];
		Arrays.fill(dp, -1);

		System.out.println(dfs(X));
		
	}

	public static int dfs(int x) {
		if (x == 1) {
			return 0;
		}

		if (dp[x] != -1) {
			return dp[x];
		}
		dp[x] = 1000001;

		if (x % 3 == 0) {
			dp[x] = Math.min(dp[x], dfs(x / 3) + 1);
		}
		if (x % 2 == 0) {
			dp[x] = Math.min(dp[x], dfs(x / 2) + 1);
		}
		dp[x] = Math.min(dp[x], dfs(x - 1) + 1);

		return dp[x];
	}

}
