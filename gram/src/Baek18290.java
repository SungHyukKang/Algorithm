import java.util.*;
import java.io.*;

public class Baek18290 {
	static int N, M, K;
	static int[][] map;
	static int[] adjDx = { 0, 1, 0, -1 };
	static int[] adjDy = { 1, 0, -1, 0 };

	static boolean[][] visited;
	static int answer = -987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		System.out.println(answer);

	}

	public static void dfs(int depth, int sum) {
		if (depth == K) {
			if (answer < sum)
				answer = sum;
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				boolean tf = true;
				for (int k = 0; k < 4; k++) {
					int nx = adjDx[k] + i;
					int ny = adjDy[k] + j;
					if (!isPossible(nx, ny)) {
						continue;
					}
					if (visited[nx][ny]) {
						tf = false;
						break;
					}
				}
				if (tf && !visited[i][j]) {
					visited[i][j] = true;
					dfs(depth + 1, sum + map[i][j]);
					visited[i][j] = false;
				}
			}
		}

	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return false;

		return true;
	}

}
