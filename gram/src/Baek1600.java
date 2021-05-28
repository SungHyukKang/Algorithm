import java.util.*;
import java.io.*;

public class Baek1600 {
	static int W;
	static int H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, K, 0 });
		boolean[][][] visited = new boolean[H][W][K + 1];
		visited[0][0][K] = true;
		int[] dx = { 0, 1, 0, -1, -1, -2, -1, -2, 1, 2, 1, 2 };
		int[] dy = { 1, 0, -1, 0, -2, -1, 2, 1, -2, -1, 2, 1 };
		int answer = -1;
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];
			int k = p[2];
			int cnt = p[3];
			if (x == H - 1 && y == W - 1) {
				answer = cnt;
				break;
			}
			for (int i = 0; i < dx.length; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if (k == 0 && i > 3)
					break;
				if (isPossible(nx, ny) && map[nx][ny] != 1) {
					if (k > 0) {
						if (i > 3) {
							if (!visited[nx][ny][k - 1]) {
								q.offer(new int[] { nx, ny, k - 1, cnt + 1 });
								visited[nx][ny][k - 1] = true;
							}
						} else {
							if (!visited[nx][ny][k]) {
								q.offer(new int[] { nx, ny, k, cnt + 1 });
								visited[nx][ny][k] = true;
							}
						}
					} else {
						if (!visited[nx][ny][k]) {
							q.offer(new int[] { nx, ny, k, cnt + 1 });
							visited[nx][ny][k] = true;
						}
					}
				}

			}
		}

		System.out.println(answer);
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= H || y < 0 || y >= W)
			return false;

		return true;

	}

}
