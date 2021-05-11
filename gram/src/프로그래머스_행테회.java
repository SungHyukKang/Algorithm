import java.util.*;

public class 프로그래머스_행테회 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int x1;
	static int y1;
	static int x2;
	static int y2;
	static int[][] cpy;
	static int min = 987654321;

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		map = new int[rows + 1][columns + 1];
		cpy = new int[rows + 1][columns + 1];
		int cnt = 1;
		visited = new boolean[rows + 1][columns + 1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				map[i][j] = cnt++;
			}
		}
		int idx = 0;
		for (int[] query : queries) {
			visited = new boolean[rows + 1][columns + 1];
			for (int i = 1; i <= rows; i++) {
				for (int j = 1; j <= columns; j++) {
					cpy[i][j] = map[i][j];
				}
			}

			x1 = query[0];
			y1 = query[1];
			x2 = query[2];
			y2 = query[3];
			min = 987654321;
			dfs(x1, y1, 0);
			answer[idx++] = min;
		}

		return answer;
	}

	public static void dfs(int r, int c, int dir) {
		if (visited[r][c] && !isPossible(r, c))
			return;
		int nx = r + dx[dir];
		int ny = c + dy[dir];
		min = Math.min(map[r][c], min);
		visited[r][c] = true;
		System.out.println(r + " " + c);
		if (isPossible(nx, ny)) {
			map[nx][ny] = cpy[r][c];
			dfs(nx, ny, dir);
		} else {
			dir++;
			if (dir == 4)
				return;
			nx = r + dx[dir];
			ny = c + dy[dir];
			map[nx][ny] = cpy[r][c];
			if (isPossible(nx, ny))
				dfs(nx, ny, dir);
		}

	}

	public static boolean isPossible(int x, int y) {
		if (x < x1 || x > x2 || y < y1 || y > y2)
			return false;
		return true;
	}

	public static void print() {
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------");
	}

	public static void main(String[] args) {
		solution(6, 6, new int[][] { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } });
	}

}
