import java.util.*;
import java.io.*;

public class Baek14940 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][] d = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(d[i], -1);
		}
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					q.offer(new int[] { i, j });
					visited[i][j] = true;
					d[i][j] = 0;
				} else if (map[i][j] == 0) {
					d[i][j] = 0;
				}
			}
		}
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];

			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if (isPossible(nx, ny, n, m) && map[nx][ny] == 1 && !visited[nx][ny]) {
					q.offer(new int[] { nx, ny });
					d[nx][ny] = d[x][y] + 1;
					visited[nx][ny] = true;
				}
			}
		}
		print(d);
	}

	public static void print(int[][] d) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				sb.append(d[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static boolean isPossible(int x, int y, int n, int m) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

}
