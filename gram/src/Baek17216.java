import java.util.*;
import java.io.*;

public class Baek17216 {
	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(dp, -1);
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dfs(i, arr[i]));
		}
		System.out.println(answer);
	}

	public static int dfs(int idx, int pre) {
		if (idx >= N)
			return 0;
		if (dp[idx] != -1) {
			return dp[idx];
		}
		dp[idx] = arr[idx];
		for (int i = idx; i < N; i++) {
			if (arr[i] < pre) {
				dp[idx] = Math.max(dp[idx], dfs(i, arr[i]) + pre);
			}
		}
		return dp[idx];
	}

}
