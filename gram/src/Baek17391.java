import java.util.*;
import java.io.*;

public class Baek17391 {
	static int N;
	static int M;
	static int[][] arr;
	static int[][][] dp;
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][Math.max(N, M)];
		q.offer(new int[] { 0, 0, 0 });
		visited[0][0][0] = true;
		int[] dx = { 0, 1 };
		int[] dy = { 1, 0 };
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];
			int cnt = p[2];
			if (x == N - 1 && y == M - 1) {
				System.out.println(cnt);
				break;
			}

			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= arr[x][y]; j++) {
					int nx = x + dx[i] * j;
					int ny = y + dy[i] * j;
					if (isPossible(nx, ny) && !visited[nx][ny][j]) {
						q.offer(new int[] { nx, ny, cnt + 1 });
						visited[nx][ny][j] = true;
					}
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
