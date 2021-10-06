import java.util.*;
import java.io.*;

public class Baek1840 {
	static int[][] map;
	static boolean[][] rowC;
	static boolean[][] colC;
	static boolean[][] squC;
	static boolean tf = false;

	static class set {
		int x, y, num;

		public set(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		set[] set = new set[81];
		rowC = new boolean[9][10];
		colC = new boolean[9][10];
		squC = new boolean[9][10];
		int[][] visited = new int[9][9];
		for (int i = 0; i < 9; i++)
			Arrays.fill(visited[i], -1);
		for (int idx = 0; idx < 81; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int num = Integer.parseInt(st.nextToken());
			if (visited[i][j] != -1) {
				System.out.println(idx + 1);
				return;
			}
			set[idx] = new set(i, j, num);
			visited[i][j] = idx + 1;
		}
		int start = 0;
		int end = 80;
		int answer = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			map = new int[9][9];
			rowC = new boolean[9][10];
			colC = new boolean[9][10];
			squC = new boolean[9][10];
			tf = false;
			boolean ttf = false;
			for (int idx = 0; idx <= mid; idx++) {
				int i = set[idx].x;
				int j = set[idx].y;
				int num = set[idx].num;
				map[i][j] = num;
				if (rowC[i][num] || colC[j][num] || squC[i / 3 * 3 + j / 3][num]) {
					ttf = true;
					break;
				}
				rowC[i][num] = true;
				colC[j][num] = true;
				squC[i / 3 * 3 + j / 3][num] = true;
			}
			if (ttf) {
				if (tf) {
					start = mid + 1;
				} else {
					end = mid - 1;
					answer = mid;
				}
				continue;
			}
			dfs(0);
			if (tf) {
				start = mid + 1;
			} else {
				end = mid - 1;
				answer = mid;
			}
		}
		if (answer == -1)
			System.out.println(-1);
		else
			System.out.println(answer + 1);
	}

	public static void dfs(int cnt) {
		if (tf) {
			return;
		}
		if (cnt == 81) {
			tf = true;
			return;
		}
		int x = cnt / 9;
		int y = cnt % 9;
		if (map[x][y] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (!rowC[x][i] && !colC[y][i] && !squC[x / 3 * 3 + y / 3][i]) {
					rowC[x][i] = true;
					colC[y][i] = true;
					squC[x / 3 * 3 + y / 3][i] = true;
					map[x][y] = i;
					dfs(cnt + 1);
					map[x][y] = 0;
					rowC[x][i] = false;
					colC[y][i] = false;
					squC[x / 3 * 3 + y / 3][i] = false;
				}
			}
		} else {
			dfs(cnt + 1);
		}
	}

}
