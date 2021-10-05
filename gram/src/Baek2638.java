import java.util.*;
import java.io.*;

public class Baek2638 {
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		int cnt = 0;
		while (true) {
			ArrayList<int[]> list = new ArrayList<>();
			boolean[][] visited = new boolean[N][M];
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { 0, 0 });
			visited[0][0] = true;
			while (!q.isEmpty()) {
				int[] p = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + p[0];
					int ny = dy[i] + p[1];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					if (!visited[nx][ny] && map[nx][ny] == 0) {
						visited[nx][ny] = true;
						q.offer(new int[] { nx, ny });
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						int count = 0;
						for (int k = 0; k < 4; k++) {
							int nx = dx[k] + i;
							int ny = dy[k] + j;
							if (nx < 0 || nx >= N || ny < 0 || ny >= M)
								continue;
							if (map[nx][ny] == 0 && visited[nx][ny]) {
								count++;
							}
							if (count > 1) {
								list.add(new int[] { i, j });
								break;
							}
						}
					}
				}
			}
			if (list.isEmpty()) {
				System.out.println(cnt);
				break;
			}
			for (int[] p : list) {
				map[p[0]][p[1]] = 0;
			}
			cnt++;
		}
	}
}
