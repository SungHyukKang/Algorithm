import java.util.*;
import java.io.*;

class Pair2234 {
	int x, y;

	public Pair2234(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Baek2234 {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] map;
	static boolean[][] visited;
	static int[] nx = { 0, 0, 1, -1 };
	static int[] ny = { 1, -1, 0, 0 };
	static Queue<Pair2234> q = new LinkedList<>();
	static ArrayList<Integer> roomsize = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		map = new int[M][N];
		visited = new boolean[M][N];

		ArrayList<Pair2234> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int max = 0;

		roomsize.add(0);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					list.add(new Pair2234(i, j));
					q.offer(new Pair2234(i, j));
					visited[i][j] = true;
					cnt++;
					int room = bfs(cnt);
					roomsize.add(room);
					max = Math.max(max, room);
				}
			}
		}
		int mmax = 0;
		for (Pair2234 p : list) {
			visited = new boolean[M][N];
			q = new LinkedList<>();
			q.offer(p);
			visited[p.x][p.y] = true;
			mmax = Math.max(mmax, bfs2(map[p.x][p.y]));
		}
		System.out.println(cnt);
		System.out.println(max);
		System.out.println(mmax);

	}

	public static int bfs(int start) {
		int num = 0;
		while (!q.isEmpty()) {
			Pair2234 p = q.poll();
			int x = p.x;
			int y = p.y;
			int[] dir = direction(arr[x][y]);
			num++;
			map[x][y] = start;
			for (int i = 0; i < dir.length; i++) {
				int dx = nx[dir[i]] + x;
				int dy = ny[dir[i]] + y;
				if (isPossible(dx, dy)) {
					q.offer(new Pair2234(dx, dy));
					visited[dx][dy] = true;
				}
			}
		}
		return num;
	}

	public static int bfs2(int start) {
		int num = roomsize.get(start);
		int max = 0;
		while (!q.isEmpty()) {
			Pair2234 p = q.poll();
			int x = p.x;
			int y = p.y;
			for (int i = 0; i < 4; i++) {
				int dx = nx[i] + x;
				int dy = ny[i] + y;
				if (isPossible(dx, dy) && map[dx][dy] != start) {
					max = Math.max(max, num + roomsize.get(map[dx][dy]));
					continue;
				}
				if (isPossible(dx, dy) && map[dx][dy] == start) {
					q.offer(new Pair2234(dx, dy));
					visited[dx][dy] = true;
				}
			}
		}
		return max;
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= N)
			return false;
		if (visited[x][y])
			return false;
		return true;
	}

	public static int[] direction(int x) {// 서 : 1 , 북 : 2 , 동 : 4 , 남 : 8
											// 0: 동 , 1 : 서 ,2 :남 3: 북
		if (x == 0) {
			return new int[] { 0, 1, 2, 3 };
		} else if (x == 1) {
			return new int[] { 0, 2, 3 };
		} else if (x == 2) {
			return new int[] { 0, 1, 2 };
		} else if (x == 3) {
			return new int[] { 0, 2 };
		} else if (x == 4) {
			return new int[] { 1, 2, 3 };
		} else if (x == 5) {
			return new int[] { 2, 3 };
		} else if (x == 6) {
			return new int[] { 1, 2 };
		} else if (x == 7) {
			return new int[] { 2 };
		} else if (x == 8) {
			return new int[] { 0, 1, 3 };
		} else if (x == 9) {
			return new int[] { 0, 3 };
		} else if (x == 10) {
			return new int[] { 0, 1 };
		} else if (x == 11) {
			return new int[] { 0 };
		} else if (x == 12) {
			return new int[] { 1, 3 };
		} else if (x == 13) {
			return new int[] { 3 };
		} else if (x == 14) {
			return new int[] { 1 };
		} else {
			return new int[] {};
		}
	}

}
