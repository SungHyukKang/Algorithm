import java.util.*;
import java.io.*;

class Robot1726 {
	int x;
	int y;
	int dir;
	int cnt;

	public Robot1726(int x, int y, int dir, int cnt) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.cnt = cnt;
	}

}

public class Baek1726 {
	static int N;
	static int M;
	static int[][] arr;
	static int[] dx = { 0, 0, 0, 1, -1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		visited = new boolean[5][N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		Queue<Robot1726> q = new LinkedList<>();
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int sdir = Integer.parseInt(st.nextToken());
		q.offer(new Robot1726(sx, sy, sdir, 0));
		visited[sdir][sx][sy] = true;
		st = new StringTokenizer(br.readLine());
		int fx = Integer.parseInt(st.nextToken());
		int fy = Integer.parseInt(st.nextToken());
		int fdir = Integer.parseInt(st.nextToken());
		while (!q.isEmpty()) {
			Robot1726 r = q.poll();
			int x = r.x;
			int y = r.y;
			int dir = r.dir;
			int cnt = r.cnt;
			if (x == fx && y == fy) {
				if (dir == fdir)
					System.out.println(cnt);
				else if (Math.abs(dir - fdir) == 1)
					System.out.println(cnt + 2);
				else
					System.out.println(cnt + 1);
				break;
			}

			for (int i = 1; i <= 3; i++) {
				int nx = x + dx[dir] * i;
				int ny = y + dy[dir] * i;
				if (isPossible(nx, ny) && arr[nx][ny] == 1) {
					break;
				}
				if (isPossible(nx, ny) && arr[nx][ny] != 1 && !visited[dir][nx][ny]) {
					q.offer(new Robot1726(nx, ny, dir, cnt + 1));
					visited[dir][nx][ny] = true;
				}
			}
			int[] cdir = direction(dir);
			for (int i = 0; i < 2; i++) {
				if (!visited[cdir[i]][x][y]) {
					q.offer(new Robot1726(x, y, cdir[i], cnt + 1));
					visited[dir][x][y] = true;
				}
			}
		}

	}

	public static boolean isPossible(int x, int y) {
		if (x <= 0 || x > N || y <= 0 || y > M)
			return false;

		return true;
	}

	public static int[] direction(int dir) {
		if (dir == 1 || dir == 2) {
			return new int[] { 3, 4 };
		} else {
			return new int[] { 1, 2 };
		}
	}

}
