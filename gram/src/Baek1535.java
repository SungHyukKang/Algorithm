import java.util.*;
import java.io.*;

public class Baek1535 {
	static int N;
	static int[] hap;
	static int[] heal;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		hap = new int[N + 1];
		heal = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			heal[i] = Integer.parseInt(st.nextToken());
			hap[i] = Integer.parseInt(st2.nextToken());
		}
		dp = new int[101][N + 1];
		for (int i = 0; i < 101; i++)
			Arrays.fill(dp[i], -1);
		System.out.println(dfs(100, 0));
	}

	public static int dfs(int hp, int n) {
		if (n == N) {
			if (hp > 0)
				return 0;
		}
		if (dp[hp][n] != -1)
			return dp[hp][n];
		dp[hp][n] = 0;

		if (hp - heal[n + 1] > 0) {
			dp[hp][n] = Math.max(dp[hp][n], dfs(hp - heal[n + 1], n + 1) + hap[n + 1]);
		}
		dp[hp][n] = Math.max(dp[hp][n], dfs(hp, n + 1));

		return dp[hp][n];

	}

}
