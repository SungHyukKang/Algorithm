import java.util.*;
import java.io.*;

class Pair17086 {
	int x, y, d;

	public Pair17086(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

}

public class Baek17086 {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] nx = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static int[] ny = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					visited = new boolean[N][M];
					ans = Math.max(ans, bfs(i, j));
				}

			}
		}
		System.out.println(ans);

	}

	public static int bfs(int i, int j) {
		Queue<Pair17086> q = new LinkedList<>();
		q.offer(new Pair17086(i, j, 0));
		int max = 0;
		visited[i][j] = true;
		while (!q.isEmpty()) {
			Pair17086 p = q.poll();
			int x = p.x;
			int y = p.y;
			int d = p.d;
			if (arr[x][y] == 1) {
				max = Math.max(d, max);
				break;
			}
			for (int c = 0; c < 8; c++) {
				int dx = nx[c] + x;
				int dy = ny[c] + y;
				if (dx < 0 || dx >= N || dy < 0 || dy >= M)
					continue;
				if (!visited[dx][dy]) {
					q.offer(new Pair17086(dx, dy, d + 1));
					visited[dx][dy] = true;
				}
			}
		}
		return max;
	}
}
