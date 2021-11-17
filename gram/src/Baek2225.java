import java.util.*;
import java.io.*;

public class Baek2225 {
	static int N;
	static int M;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][M + 1];
		for (int i = 0; i < N; i++)
			Arrays.fill(dp[i], -1);

		System.out.println(dfs(0, 0));
	}

	public static int dfs(int sum, int cnt) {
		if (sum == N)
			return 1;
		if (cnt == M) {
			if (sum == N)
				return dp[sum][cnt] = 1;
			return 0;
		}

		if (dp[sum][cnt] != -1) {
			return dp[sum][cnt];
		}
		dp[sum][cnt] = 0;
		for (int i = 0; i <= N; i++) {
			if (sum + i <= N)
				dp[sum][cnt] = (dp[sum][cnt] + dfs(sum + i, cnt + 1)) % 1000000000;
		}

		return dp[sum][cnt];

	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println("");
		}
		System.out.println("---------------------------");
	}

}
