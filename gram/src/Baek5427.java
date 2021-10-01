import java.util.*;
import java.io.*;

public class Baek5427 {
	static int w, h;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Node {
		int x, y, d;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			char[][] map = new char[h][w];
			Queue<Node> q = new LinkedList<>();
			Queue<Node> fire = new LinkedList<>();
			boolean[][] visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '@') {
						q.offer(new Node(i, j, 0));
						visited[i][j] = true;
					} else if (map[i][j] == '*') {
						fire.offer(new Node(i, j));
					}
				}
			}
			boolean tf = true;
			while (tf) {
				int qSize = q.size();
				int fSize = fire.size();
				if (qSize == 0) {
					sb.append("IMPOSSIBLE").append("\n");
					break;
				}
				while (fSize-- > 0) {
					Node cur = fire.poll();
					int x = cur.x;
					int y = cur.y;
					for (int i = 0; i < 4; i++) {
						int nx = dx[i] + x;
						int ny = dy[i] + y;

						if (!isExit(nx, ny) && map[nx][ny] != '#' && map[nx][ny] != '*') {
							fire.offer(new Node(nx, ny));
							map[nx][ny] = '*';
						}
					}
				}

				while (qSize-- > 0 && tf) {
					Node cur = q.poll();
					int x = cur.x;
					int y = cur.y;
					int d = cur.d;
					for (int i = 0; i < 4; i++) {
						int nx = dx[i] + x;
						int ny = dy[i] + y;
						if (isExit(nx, ny)) {
							sb.append((d + 1)).append("\n");
							tf = false;
							break;
						}
						if (!visited[nx][ny] && map[nx][ny] != '*' && map[nx][ny] != '#') {
							q.offer(new Node(nx, ny, d + 1));
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
		System.out.println(sb);
	}

	public static boolean isExit(int x, int y) {
		if (x < 0 || x >= h || y < 0 || y >= w)
			return true;

		return false;
	}

}
