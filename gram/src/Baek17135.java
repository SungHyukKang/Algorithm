import java.util.*;
import java.io.*;

class Pair17135 {
	int x;
	int y;
	int cnt;

	public Pair17135(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

}

public class Baek17135 {
	static int N;
	static int M;
	static int D;
	static int enemy = 0;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] visit;
	static Stack<Integer> stack = new Stack<>();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					enemy++;
			}
		}
		dfs(0, 0);
		System.out.println(max);
	}

	public static int[][] cpyMap(int[][] map) {
		int[][] copyMap = new int[map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		return copyMap;
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return false;
		return true;
	}

	public static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}

	public static void dfs(int depth, int idx) {
		if (depth == 3) {
			Queue<Pair17135> q = new LinkedList<>();
			int[][] copyMap = cpyMap(map);
			int cpyEnemy = enemy;
			int kill = 0;
			while (true) {
				HashMap<Integer, ArrayList<Pair17135>> hsmap = new HashMap<>();
				if (cpyEnemy <= 0)
					break;
				for (int i = 0; i < 3; i++) {
					hsmap.put(i, new ArrayList<>());
					q = new LinkedList<>();
					q.offer(new Pair17135(N, stack.get(i), 0));
					visited = new boolean[N][M];
					while (!q.isEmpty()) {
						Pair17135 p = q.poll();
						int x = p.x;
						int y = p.y;
						int cnt = p.cnt;
						if (cnt == D)
							continue;
						for (int j = 0; j < 4; j++) {
							int nx = dx[j] + x;
							int ny = dy[j] + y;
							if (isPossible(nx, ny) && !visited[nx][ny]) {
								if (copyMap[nx][ny] == 1) {
									hsmap.get(i).add(new Pair17135(nx, ny, cnt + 1));
								}
								q.offer(new Pair17135(nx, ny, cnt + 1));
								visited[nx][ny] = true;
							}
						}
					}
					if (hsmap.get(i).size() > 0) {
						Collections.sort(hsmap.get(i), new Comparator<Pair17135>() {
							@Override
							public int compare(Pair17135 arg0, Pair17135 arg1) {
								if (arg0.cnt > arg1.cnt)
									return Integer.compare(arg0.cnt, arg1.cnt);
								else if (arg0.cnt == arg1.cnt) {
									if (arg0.y > arg1.y) {
										return Integer.compare(arg0.y, arg1.y);
									}
								}
								return -1;
							}
						});
					}
				}
				for (int i = 0; i < 3; i++) {
					if (hsmap.get(i).size() > 0) {
						int hx = hsmap.get(i).get(0).x;
						int hy = hsmap.get(i).get(0).y;
						if (copyMap[hx][hy] == 1) {
							kill++;
							cpyEnemy--;
						}
						copyMap[hx][hy] = 0;
					}
				}

				for (int i = 0; i < M; i++) {
					if (copyMap[N - 1][i] == 1)
						cpyEnemy--;
				}
				for (int i = N - 1; i >= 0; i--) {
					Arrays.fill(copyMap[i], 0);
					if (i == 0)
						continue;
					for (int j = 0; j < M; j++) {
						if (copyMap[i - 1][j] == 1) {
							copyMap[i][j] = 1;
						}
					}
				}
			}
			max = Math.max(max, kill);
			return;
		}

		for (int i = idx; i < M; i++) {
			if (!visit[idx]) {
				visit[idx] = true;
				stack.push(i);
				dfs(depth + 1, i + 1);
				stack.pop();
				visit[idx] = false;
			}
		}
	}
}
