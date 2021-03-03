import java.util.*;
import java.io.*;

class Pair16948 {
	int x, y, d;

	public Pair16948(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

}

public class Baek16948 {
	static int N;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nx = { -2, -2, 0, 0, 2, 2 };
		int[] ny = { -1, 1, -2, 2, -1, 1 };

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Pair16948> q = new LinkedList<>();
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int ex = Integer.parseInt(st.nextToken());
		int ey = Integer.parseInt(st.nextToken());
		visited = new boolean[N][N];
		visited[sx][sy] = true;
		int min = 987654321;
		q.offer(new Pair16948(sx, sy, 0));
		while (!q.isEmpty()) {
			Pair16948 p = q.poll();
			int x = p.x;
			int y = p.y;
			int d = p.d;
			if (x == ex && y == ey) {
				System.out.println(d);
				System.exit(0);

			}
			for (int i = 0; i < 6; i++) {
				int dx = nx[i] + x;
				int dy = ny[i] + y;
				if (isPossible(dx, dy)) {
					visited[dx][dy] = true;
					q.offer(new Pair16948(dx, dy, d + 1));
				}
			}
		}
		System.out.println("-1");
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		if (visited[x][y])
			return false;
		return true;
	}
}
