import java.util.*;
import java.io.*;

public class Baek5557 {
	static int N;
	static int[] arr;
	static long[][] dp;
	static int target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N - 1];
		dp = new long[104][N - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		target = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 104; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(dfs(arr[0], 1));
	}

	public static long dfs(int sum, int idx) {
		// base condition
		if (idx == N - 1) {
			if (sum == target)
				return 1;
			return 0;
		}

		if (dp[sum][idx] != -1) {
			return dp[sum][idx];
		}
		dp[sum][idx] = 0;
		if (sum - arr[idx] >= 0)
			dp[sum][idx] += dfs(sum - arr[idx], idx + 1);
		if (sum + arr[idx] <= 20)
			dp[sum][idx] += dfs(sum + arr[idx], idx + 1);

		return dp[sum][idx];
	}

	public static void print() {
		for (int i = 0; i <= target; i++) {
			for (int j = 0; j < N - 1; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

}
