import java.util.*;
import java.io.*;

public class Baek21923 {
	static int N, M;
	static int[][] map;
	static int[][][] dp;
	static int[][] dx = { { -1, 0 }, { 1, 0 } };
	static int[] dy = { 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[2][N][M];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++)
				Arrays.fill(dp[i][j], -1);
		}

		System.out.println(dfs(0, N - 1, 0));
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return false;
		return true;
	}

	public static int dfs(int status, int x, int y) {
		if (status == 1 && x == N - 1 && y == M - 1) {
			return map[x][y];
		}

		if (dp[status][x][y] != -1)
			return dp[status][x][y];
		dp[status][x][y] = Integer.MIN_VALUE;
		for (int i = 0; i < 2; i++) {
			int nx = dx[status][i] + x;
			int ny = dy[i] + y;
			if (isPossible(nx, ny)) {
				dp[status][x][y] = Math.max(dp[status][x][y], dfs(status, nx, ny) + map[x][y]);
			}
		}
		if (status == 0)
			dp[status][x][y] = Math.max(dp[status][x][y], dfs(1, x, y) + map[x][y]);

		return dp[status][x][y];

	}

}
