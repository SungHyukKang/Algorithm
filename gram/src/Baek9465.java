import java.util.*;
import java.io.*;

public class Baek9465 {
	static int[][][] dp;
	static int n;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			dp = new int[2][2][n];
			arr = new int[2][n];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 2; i++) {
				Arrays.fill(dp[0][i], -1);
				Arrays.fill(dp[1][i], -1);
			}
			int answer = Math.max(dfs(0, 0, 0), dfs(1, 1, 0));
			sb.append(answer + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int dfs(int z, int x, int y) {
		if (y == n - 1) {
			return arr[x][y];
		}

		if (dp[z][x][y] != -1) {
			return dp[z][x][y];
		}
		dp[z][x][y] = 0;
		if (isPossible(x + 1, y + 1)) {
			dp[z][x][y] = Math.max(dp[z][x][y], dfs(z, x + 1, y + 1) + arr[x][y]);
		}
		if (isPossible(x - 1, y + 1)) {
			dp[z][x][y] = Math.max(dp[z][x][y], dfs(z, x - 1, y + 1) + arr[x][y]);
		}
		if (isPossible(x, y + 2)) {
			dp[z][x][y] = Math.max(dp[z][x][y], dfs(z, x, y + 2) + arr[x][y]);
		}
		if (isPossible(x + 1, y + 2)) {
			dp[z][x][y] = Math.max(dp[z][x][y], dfs(z, x + 1, y + 2) + arr[x][y]);
		}
		if (isPossible(x - 1, y + 2)) {
			dp[z][x][y] = Math.max(dp[z][x][y], dfs(z, x - 1, y + 2) + arr[x][y]);
		}
		return dp[z][x][y];
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= 2 || y < 0 || y >= n) {
			return false;
		}
		return true;
	}

}
