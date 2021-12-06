import java.util.*;
import java.io.*;

public class Baek21938 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] pixel = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int r = Integer.parseInt(st.nextToken());
				int g = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				pixel[i][j] = (r + g + b) / 3;
			}
		}
		int T = Integer.parseInt(br.readLine());
		boolean[][] visited = new boolean[N][M];
		int ans = 0;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (pixel[i][j] >= T && !visited[i][j]) {
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] { i, j });
					ans++;
					visited[i][j] = true;
					while (!q.isEmpty()) {
						int[] p = q.poll();
						int x = p[0];
						int y = p[1];
						for (int z = 0; z < 4; z++) {
							int nx = x + dx[z];
							int ny = y + dy[z];
							if (nx < 0 || nx >= N || ny < 0 || ny >= M)
								continue;
							if (pixel[nx][ny] >= T && !visited[nx][ny]) {
								q.offer(new int[] { nx, ny });
								visited[nx][ny] = true;
							}
						}
					}
				}
			}
		}
		System.out.println(ans);

	}

}
