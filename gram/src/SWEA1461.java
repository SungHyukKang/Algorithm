import java.util.*;
import java.io.*;

public class SWEA1461 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N;
	static ArrayList<int[]> list;
	static int min;
	static int cnt;
	static int maxCore;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			min = 987654321;
			list = new ArrayList<>();
			maxCore = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
							map[i][j] = -1;
							continue;
						}
						list.add(new int[] { i, j });
					}
				}
			}
			dfs(0, 0);
			sb.append("#" + test_case + " " + min + "\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int idx, int core) {
		if (idx == list.size()) {
			if (maxCore < core) {
				maxCore = core;
				min = cnt;
			} else if (maxCore == core) {
				min = Math.min(min, cnt);
			}

			return;
		}
		int nextX = list.get(idx)[0];
		int nextY = list.get(idx)[1];
		for (int j = 0; j < 4; j++) {
			if (isPossible(nextX, nextY, j)) {
				dfs(idx + 1, core + 1);
				initVisited(nextX, nextY, j);
			} else {
				dfs(idx + 1, core);
			}
		}
	}

	public static void initVisited(int x, int y, int dir) {
		while (true) {
			x = dx[dir] + x;
			y = dy[dir] + y;
			if (x < 0 || x >= N || y < 0 || y >= N)
				break;
			visited[x][y] = false;
			cnt--;
		}
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(visited[i][j] ? "1 " : "0 ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}

	public static boolean isPossible(int x, int y, int dir) {
		int initX = x;
		int initY = y;
		boolean tf = true;
		while (true) {
			x = dx[dir] + x;
			y = dy[dir] + y;
			if (x < 0 || x >= N || y < 0 || y >= N)
				break;
			if (map[x][y] != 0 || visited[x][y]) {
				tf = false;
				break;
			}
		}

		if (tf) {
			while (true) {
				initX = dx[dir] + initX;
				initY = dy[dir] + initY;
				if (initX < 0 || initX >= N || initY < 0 || initY >= N)
					break;
				visited[initX][initY] = true;
				cnt++;
			}
		}

		return tf;
	}

}
