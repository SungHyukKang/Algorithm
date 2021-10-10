import java.util.*;
import java.io.*;

public class Baek2411 {
	static int N, M, A, B;
	static int[][] map;
	static int[][][] dp;
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M][A + 1];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				Arrays.fill(dp[i][j], -1);
		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		for (int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = -1;
		}

		System.out.println(dfs(0, 0, 0));

	}

	public static int dfs(int x, int y, int item) {
		if (x == N - 1 && y == M - 1) {
			if (item == A)
				return 1;
			else
				return 0;
		}
		if (dp[x][y][item] != -1)
			return dp[x][y][item];
		dp[x][y][item] = 0;
		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= N || ny >= M)
				continue;
			if (map[nx][ny] != -1)
				dp[x][y][item] += dfs(nx, ny, map[x][y] == 1 ? item + 1 : item);
		}
		return dp[x][y][item];
	}

}
