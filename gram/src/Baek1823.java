import java.util.*;
import java.io.*;

public class Baek1823 {
	static int N;
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(dp[i], -1);
		System.out.println(dfs(0, N - 1, 1));
	}

	public static int dfs(int s, int e, int day) {
		if (s > e)
			return 0;

		if (dp[s][e] != -1)
			return dp[s][e];
		int f = dfs(s + 1, e, day + 1) + arr[s] * day;
		int l = dfs(s, e - 1, day + 1) + arr[e] * day;
		dp[s][e] = Math.max(f, l);
		return dp[s][e];
	}
}
