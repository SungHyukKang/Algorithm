import java.util.*;
import java.io.*;

public class Baek2580 {
	static int[][] map;
	static boolean[][] rowC = new boolean[9][10];
	static boolean[][] colC = new boolean[9][10];
	static boolean[][] squC = new boolean[9][10];
	static boolean tf = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					rowC[i][map[i][j]] = true;
					colC[j][map[i][j]] = true;
					squC[i / 3 * 3 + j / 3][map[i][j]] = true;
				}
			}
		}
		dfs(0);
	}

	public static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				sb.append(map[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int cnt) {
		if (cnt == 81 || tf) {
			if (!tf) {
				print();
				tf = true;
			}
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
