import java.util.*;
import java.io.*;

public class Baek21736 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		class Pair {
			int x, y;

			public Pair(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && arr[i][j] == 'I') {
					q.offer(new Pair(i, j));
					visited[i][j] = true;
					while (!q.isEmpty()) {
						Pair p = q.poll();
						int x = p.x;
						int y = p.y;
						if (arr[x][y] == 'P')
							cnt++;
						for (int c = 0; c < 4; c++) {
							int nx = dx[c] + x;
							int ny = dy[c] + y;
							if (nx < 0 || nx >= N || ny < 0 || ny >= M)
								continue;
							if (visited[nx][ny] || arr[nx][ny] == 'X')
								continue;
							q.offer(new Pair(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
		System.out.println(cnt == 0 ? "TT" : cnt);
	}

}
