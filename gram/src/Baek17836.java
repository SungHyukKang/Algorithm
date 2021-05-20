import java.util.*;
import java.io.*;

public class Baek17836 {
	static int[][] D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int gramx = -1;
		int gramy = -1;
		boolean[][] visited = new boolean[N][M];
		int[][] map = new int[N][M];
		D = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					gramx = i;
					gramy = j;
				}
			}
		}
		class Pair {
			int x, y;

			public Pair(int x, int y) {
				this.x = x;
				this.y = y;
			}

		}
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0, 0));
		visited[0][0] = true;
		ArrayList<Integer> list = new ArrayList<>();
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			if (D[x][y] > T)
				continue;
			if (x == N - 1 && y == M - 1) {
				list.add(D[x][y]);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (!visited[nx][ny] && map[nx][ny] != 1) {
					q.offer(new Pair(nx, ny));
					D[nx][ny] = D[x][y] + 1;
					visited[nx][ny] = true;
				}
			}
		}
		q = new LinkedList<>();
		visited = new boolean[N][M];
		q.offer(new Pair(gramx, gramy));
		visited[gramx][gramy] = true;
		if (D[gramx][gramy] != 0)
			while (!q.isEmpty()) {
				Pair p = q.poll();
				int x = p.x;
				int y = p.y;
				if (x == N - 1 && y == M - 1) {
					list.add(D[x][y]);
					break;
				}
				if (D[x][y] >= T)
					continue;
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + x;
					int ny = dy[i] + y;
					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					if (!visited[nx][ny]) {
						q.offer(new Pair(nx, ny));
						D[nx][ny] = D[x][y] + 1;
						visited[nx][ny] = true;
					}
				}
			}
		if (list.isEmpty()) {
			System.out.println("Fail");
		} else {
			Collections.sort(list);
			System.out.println(list.get(0));

		}

	}

	public static void print() {
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D[i].length; j++) {
				System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}

}
