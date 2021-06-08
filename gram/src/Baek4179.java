import java.util.*;
import java.io.*;

class Pair4179 {
	int x;
	int y;
	int cnt;

	public Pair4179(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

	public Pair4179(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Baek4179 {
	static int R;
	static int C;
	static char[][] map;
	static Queue<Pair4179> q = new LinkedList<>();
	static Queue<Pair4179> f = new LinkedList<>();
	static int[] nx = { 0, 1, 0, -1 };
	static int[] ny = { 1, 0, -1, 0 };
	static boolean[][] visited = new boolean[R][C];
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String X = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = X.charAt(j);
				if (map[i][j] == 'J') {
					q.offer(new Pair4179(i, j, 0));
					visited[i][j] = true;
					map[i][j] = '.';
				} else if (map[i][j] == 'F') {
					f.offer(new Pair4179(i, j));
				}
			}
		}

		while (true) {
			if (q.isEmpty())
				break;

			moveFire();

			if (moveJihun())
				break;

		}
		System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
	}

	public static void moveFire() {
		int size = f.size();
		while (size-- > 0) {
			Pair4179 fp = f.poll();
			int x = fp.x;
			int y = fp.y;

			for (int i = 0; i < 4; i++) {
				int dx = nx[i] + x;
				int dy = ny[i] + y;
				if (isPossible(dx, dy) && map[dx][dy] == '.') {
					f.offer(new Pair4179(dx, dy));
					map[dx][dy] = 'F';
				}
			}
		}
	}

	public static boolean moveJihun() {
		boolean tf = false;
		int size = q.size();
		while (size-- > 0) {
			Pair4179 p = q.poll();
			int x = p.x;
			int y = p.y;
			int cnt = p.cnt;
			for (int i = 0; i < 4; i++) {
				int dx = nx[i] + x;
				int dy = ny[i] + y;
				if (isPossible(dx, dy) && map[dx][dy] == '.' && !visited[dx][dy]) {
					q.offer(new Pair4179(dx, dy, cnt + 1));
					visited[dx][dy] = true;
				} else if (!isPossible(dx, dy)) {
					answer = cnt + 1;
					tf = true;
					break;
				}
			}
		}
		return tf;
	}

	public static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= R || y < 0 || y >= C)
			return false;
		return true;
	}
}
