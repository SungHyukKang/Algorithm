import java.util.*;
import java.io.*;

public class Baek17485 {
	static int N;
	static int M;
	static int[][] map;
	static int[][][] dp;
	static int[] dx = { 0, 1, 1, 1 };
	static int[] dy = { 0, -1, 0, 1 };
	static int INF = 987654321;

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
		dp = new int[4][N][M];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		int answer = INF;
		for (int i = 0; i < M; i++) {
			answer = Math.min(answer, dfs(0, 0, 0, i));
		}
		System.out.println(answer);
	}

	public static int dfs(int depth, int pre, int x, int y) {
		if (depth == N) {
			return 0;
		}

		if (dp[pre][x][y] != -1) {
			return dp[pre][x][y];
		}
		dp[pre][x][y] = INF;
		for (int i = 1; i <= 3; i++) {
			if (pre == i)
				continue;
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (ny >= 0 && ny < M)
				dp[pre][x][y] = Math.min(dp[pre][x][y], dfs(depth + 1, i, nx, ny) + map[x][y]);
		}

		return dp[pre][x][y];

	}

}
