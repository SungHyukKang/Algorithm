import java.util.*;
import java.io.*;

public class Baek2294 {
	static int[] arr;
	static int[][] dp;
	static int k;
	static int n;
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[101][10001];
		HashSet<Integer> hsset = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			hsset.add(Integer.parseInt(br.readLine()));
		}
		int c = 1;
		arr = new int[hsset.size() + 1];
		for (int x : hsset) {
			arr[c++] = x;
		}
		Arrays.sort(arr);
		for (int i = 0; i < 101; i++) {
			Arrays.fill(dp[i], -1);
		}
		int ans = dfs(1, k);
		System.out.println(ans == 987654321 ? -1 : ans);

	}

	public static int dfs(int idx, int k) {
		if (k <= 0) {
			return k == 0 ? 0 : INF;
		}
		if (dp[idx][k] != -1) {
			return dp[idx][k];
		}
		dp[idx][k] = INF;

		for (int i = idx; i < arr.length; i++) {
			dp[idx][k] = Math.min(dp[idx][k], dfs(i, k - arr[i]) + 1);
		}

		return dp[idx][k];
	}

}
