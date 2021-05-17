import java.util.*;
import java.io.*;

public class Baek14716 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[M][N];
		boolean[][] visited = new boolean[M][N];
		int[] dx = { 0, 0, 1, 1, 1, -1, -1, -1 };
		int[] dy = { 1, -1, 0, 1, -1, 0, 1, -1 };
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> q = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					cnt++;
					q.offer(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] pair = q.poll();
						int x = pair[0];
						int y = pair[1];
						for (int d = 0; d < 8; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							if (nx < 0 || nx >= M || ny < 0 || ny >= N)
								continue;
							if (!visited[nx][ny] && arr[nx][ny] == 1) {
								q.offer(new int[] { nx, ny });
								visited[nx][ny] = true;
							}
						}

					}
				}
			}
		}
		System.out.println(cnt);

	}
}
