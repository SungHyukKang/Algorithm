import java.util.*;
import java.io.*;

public class Baek11062 {
	static int[] arr;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[N];
			dp = new int[N][N][3];
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Arrays.fill(dp[i][j], -1);
				}
			}
			sb.append(dfs(0, N - 1, 1) + "\n");
		}
		System.out.println(sb);
	}

	public static int dfs(int i, int j, int turn) {

		if (i >= j) {
			if (turn == 1)
				return arr[i];
			else
				return 0;
		}

		if (dp[i][j][turn] != -1)
			return dp[i][j][turn];

		if (turn == 1) {
			dp[i][j][turn] = Math.max(dfs(i + 1, j, 3 - turn) + arr[i], dfs(i, j - 1, 3 - turn) + arr[j]);
		} else {
			dp[i][j][turn] = Math.min(dfs(i + 1, j, 3 - turn), dfs(i, j - 1, 3 - turn));
		}
		return dp[i][j][turn];
	}

}
