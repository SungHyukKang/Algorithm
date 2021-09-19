import java.util.*;
import java.io.*;

public class Baek17129 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '2') {
					q.offer(new int[] { i, j, 0 });
					visited[i][j] = true;
				}
			}
		}
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int answer = -1;
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];
			int cnt = p[2];
			if (map[x][y] > '2') {
				answer = cnt;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (!visited[nx][ny] && map[nx][ny] != '1') {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny, cnt + 1 });
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(answer == -1 ? "NIE" : "TAK\n" + answer);
		System.out.println(sb);

	}

}
