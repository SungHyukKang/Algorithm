import java.util.*;
import java.io.*;

class Pair21609 {
	int x, y;
	int cnt;
	int zb;
	ArrayList<Pair21609> list = new ArrayList<>();

	public Pair21609(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair21609(int x, int y, int cnt, int zb) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.zb = zb;
	}

	@Override
	public String toString() {
		return "x=" + x + ", y=" + y + ", cnt=" + cnt + ", zb=" + zb;
	}

}

public class Baek21609 {
	static int[][] map;
	static int N;
	static int M;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<Pair21609> q = new LinkedList<>();
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int j = 0;
			while (st.hasMoreTokens()) {
				map[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		while (true) {
			q = new LinkedList<>();
			ArrayList<Pair21609> list = new ArrayList<>();
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != -1 && map[i][j] != 0 && map[i][j] != M + 1 && !visited[i][j]) {
						visited[i][j] = true;
						int cnt = 0;
						int zb = 0;
						q.offer(new Pair21609(i, j));
						Pair21609 p = bfs(cnt, zb, i, j);
						if (p.cnt >= 2 && p.cnt - p.zb >= 1)
							list.add(p);
						zbReset();
					}
				}
			}
			Collections.sort(list, new Comparator<Pair21609>() {
				@Override
				public int compare(Pair21609 o1, Pair21609 o2) {
					if (o1.cnt < o2.cnt) {
						return 1;
					} else if (o1.cnt == o2.cnt) {
						if (o1.zb < o2.zb) {
							return 1;
						} else if (o1.zb == o2.zb) {
							if (o1.x < o2.x)
								return 1;
							else if (o1.x == o2.x) {
								if (o2.y < o2.y) {
									return 1;
								}
							}
						}
					}
					return -1;
				}
			});
			if (list.isEmpty())
				break;
			if (list.get(0).cnt < 2)
				break;
			ans += (list.get(0).cnt * list.get(0).cnt);
			for (Pair21609 pp : list.get(0).list) {
				map[pp.x][pp.y] = M + 1;
			}
			for (int i = N - 2; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != -1 && map[i][j] != M + 1) {
						gravity(i, j);
					}
				}
			}
			leftRotate();
			for (int i = N - 2; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != -1 && map[i][j] != M + 1) {
						gravity(i, j);
					}
				}
			}
		}
		System.out.println(ans);
	}

	// 중력
	public static void gravity(int x, int y) {

		int init = map[x][y];
		x++;
		while (x != N && map[x][y] == M + 1) {
			int temp = map[x][y];
			map[x][y] = init;
			map[x - 1][y] = temp;
			x++;
		}
	}

	// 반시계방향으로 배열 회전
	public static void leftRotate() {
		int[][] rtmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				rtmap[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[N - j - 1][i] = rtmap[i][j];
			}
		}
	}

	public static void zbReset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					visited[i][j] = false;
				}
			}
		}
	}

	// bfs
	public static Pair21609 bfs(int cnt, int zb, int i, int j) {
		ArrayList<Pair21609> list = new ArrayList<>();
		while (!q.isEmpty()) {
			Pair21609 p = q.poll();
			int x = p.x;
			int y = p.y;
			list.add(new Pair21609(x, y));
			cnt++;
			if (map[x][y] == 0)// 무지개블록 ++
				zb++;
			for (int z = 0; z < 4; z++) {
				int nx = dx[z] + x;
				int ny = dy[z] + y;
				if (isPossible(nx, ny) && (!visited[nx][ny] || map[nx][ny] == 0) && map[nx][ny] != -1) {// nx,ny가 맵 안에
																										// 있는 좌표이고 방문하지
																										// 않았거나 무지개
																										// 블록이면서 검은색 블록이
																										// 아닐 때,
					if (map[nx][ny] == 0 && !visited[nx][ny]) {
						q.offer(new Pair21609(nx, ny));
						visited[nx][ny] = true;
					} else if (map[nx][ny] == map[x][y] && map[nx][ny] != 0) {
						q.offer(new Pair21609(nx, ny));
						visited[nx][ny] = true;
					} else if (map[x][y] == 0 && !visited[nx][ny] && map[i][j] == map[nx][ny]) {
						q.offer(new Pair21609(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
		Pair21609 p = new Pair21609(i, j, cnt, zb);
		p.list = list;
		return p;
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;

		return true;
	}

	public static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] == -1 ? 9 + " " : map[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("------------------------");
	}
}
