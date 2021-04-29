import java.util.*;
import java.io.*;

class Pair21610 {
	int x, y;
	int cnt;

	public Pair21610(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair21610(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}

}

public class Baek21610 {
	static int N;
	static int M;
	static int[][] map;
	static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static Queue<Pair21610> q = new LinkedList<>();
	static Queue<Pair21610> qq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		q.add(new Pair21610(N - 1, 0));
		q.add(new Pair21610(N - 1, 1));
		q.add(new Pair21610(N - 2, 0));
		q.add(new Pair21610(N - 2, 1));
		qq = new LinkedList<>();

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()) % N;
			boolean[][] visited = new boolean[N][N];
			int size = q.size();
			while (size-- > 0) {
				Pair21610 p = q.poll();
				int x = p.x;
				int y = p.y;
				int nx = x + dx[d] * s;
				int ny = y + dy[d] * s;
				if (nx < 0) {
					nx = nx + N;
				}
				if (ny < 0) {
					ny = ny + N;
				}
				if (nx >= N) {
					nx = nx - N;
				}
				if (ny >= N)
					ny = ny - N;
				map[nx][ny]++;
				visited[nx][ny] = true;
				q.offer(new Pair21610(nx, ny));
			}
			cloud();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] >= 2) {
						map[i][j] = map[i][j] - 2;
						q.offer(new Pair21610(i, j));
					}
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}

	public static void cloud() {
		while (!q.isEmpty()) {
			int cnt = 0;
			Pair21610 p = q.poll();
			int nx = p.x;
			int ny = p.y;
			for (int i = 2; i <= 8; i = i + 2) {
				int nnx = nx + dx[i];
				int nny = ny + dy[i];
				if (isPossible(nnx, nny) && map[nnx][nny] > 0) {
					cnt++;
				}
			}
			if (cnt > 0)
				qq.offer(new Pair21610(nx, ny, cnt));
		}
		while (!qq.isEmpty()) {
			Pair21610 p = qq.poll();
			map[p.x][p.y] = map[p.x][p.y] + p.cnt;
		}
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------");
	}

}
