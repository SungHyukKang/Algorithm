import java.util.*;
import java.io.*;

public class Baek2229 {
	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		dp = new int[N];

		Arrays.fill(dp, -1);

		System.out.println(dfs(0));

	}

	public static int dfs(int depth) {
		if (depth == N) {
			return 0;
		}
		if (dp[depth] != -1)
			return dp[depth];
		dp[depth] = 0;
		int max = arr[depth];
		int min = arr[depth];
		for (int i = depth; i < N; i++) {
			max = Math.max(arr[i], max);
			min = Math.min(arr[i], min);
			dp[depth] = Math.max(dp[depth], dfs(i + 1) + max - min);
		}

		return dp[depth];
	}

}
