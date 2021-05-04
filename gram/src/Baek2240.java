import java.util.*;
import java.io.*;

public class Baek2240 {
	static int[] arr;
	static int[][] dp;
	static int N;
	static int W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp = new int[1001][31];
		for (int i = 0; i < 1001; i++) {
			Arrays.fill(dp[i], -1);
		}
		int test1 = dfs(0, W, 1);
		for (int i = 0; i < 1001; i++) {
			Arrays.fill(dp[i], -1);
		}
		int test2 = dfs(0, W - 1, 2);
		System.out.println(Math.max(test1, test2));

	}

	public static int dfs(int index, int count, int pre) {
		if (index == N) {
			return 0;
		}

		if (dp[index][count] != -1) {
			return dp[index][count];
		}
		dp[index][count] = 0;
		int jadu = arr[index] == pre ? 1 : 0;
		dp[index][count] = Math.max(dp[index][count], dfs(index + 1, count, pre) + jadu);
		if (count > 0) {
			dp[index][count] = Math.max(dp[index][count], dfs(index + 1, count - 1, 3 - pre) + jadu);
		}

		return dp[index][count];
	}

}
