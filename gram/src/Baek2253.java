import java.util.*;
import java.io.*;

public class Baek2253 {
	static int N;
	static int M;
	static int[] arr;
	static int[][] dp;
	static int INF = 987654321;
	static int answer = 210000000;
	static boolean tf = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		dp = new int[250][N + 1];
		for (int i = 0; i < M; i++) {
			arr[Integer.parseInt(br.readLine())] = -1;
		}
		for (int i = 0; i < 250; i++)
			Arrays.fill(dp[i], -1);
		int x = dfs(1, 0);
		System.out.println(tf ? x : "-1");
	}

	public static int dfs(int pre, int m) {
		if (pre == N) {
			tf = true;
			return 0;
		}
		if (dp[m][pre] != -1)
			return dp[m][pre];

		dp[m][pre] = INF;

		if (pre + m - 1 <= N && m - 1 > 0 && arr[pre + m - 1] != -1) {
			dp[m][pre] = Math.min(dp[m][pre], dfs(pre + m - 1, m - 1) + 1);
		}

		if (pre + m <= N && m > 0 && arr[pre + m] != -1) {
			dp[m][pre] = Math.min(dp[m][pre], dfs(pre + m, m) + 1);
		}

		if (pre + m + 1 <= N && m + 1 > 0 && arr[pre + m + 1] != -1) {
			dp[m][pre] = Math.min(dp[m][pre], dfs(pre + m + 1, m + 1) + 1);
		}

		return dp[m][pre];
	}

	public static boolean isPossible(int pre) {
		if (pre < 0 || pre >= N)
			return false;
		return true;
	}
}
