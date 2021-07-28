import java.util.*;

import java.io.*;

class Pair16973 {
	int x;
	int y;
	int cnt;

	public Pair16973(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

}

public class Baek16973 {
	static int N;
	static int M;
	static int[][] map;
	static int H;
	static int W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int sr = Integer.parseInt(st.nextToken()) - 1;
		int sc = Integer.parseInt(st.nextToken()) - 1;
		int fr = Integer.parseInt(st.nextToken()) - 1;
		int fc = Integer.parseInt(st.nextToken()) - 1;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		Queue<Pair16973> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + sr;
			int ny = dy[i] + sc;
			if (isPossible(nx, ny) && map[nx][ny] == 0) {
				q.offer(new Pair16973(nx, ny, 1));
				visited[nx][ny] = true;
			}
		}
		int answer = -1;
		while (!q.isEmpty()) {
			Pair16973 p = q.poll();
			int x = p.x;
			int y = p.y;
			int cnt = p.cnt;
			if (x == fr && y == fc) {
				answer = cnt;
				break;
			}
			boolean tf = true;
			for (int j = 0; j < H; j++) {
				if (!tf) {
					break;
				}
				if (map[x + j][y + W - 1] == 1) {
					tf = false;
					break;
				}
				if (map[x + j][y] == 1) {
					tf = false;
					break;
				}
			}
			for (int z = 0; z < W; z++) {
				if (!tf) {
					break;
				}
				if (map[x + H - 1][y + z] == 1) {
					tf = false;
					break;
				}
				if (map[x][y + z] == 1) {
					tf = false;
					break;
				}
			}
			if (tf)
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + x;
					int ny = dy[i] + y;
					if (isPossible(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny]) {
						q.offer(new Pair16973(nx, ny, cnt + 1));
						visited[nx][ny] = true;
					}
				}

		}
		System.out.println(answer);

	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x + H - 1 >= N || y < 0 || y + W - 1 >= M)
			return false;

		return true;
	}

}
