import java.util.*;
import java.io.*;

public class Baek1189 {
	static int R;
	static int C;
	static int K;
	static int[][] arr;
	static boolean[][] visited;
	static int cnt = 0;
	static int[] nx = { 0, 1, 0, -1 };
	static int[] ny = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String X = br.readLine();
			for (int j = 0; j < C; j++) {
				if (X.charAt(j) == 'T') {
					arr[i][j] = -1;
				}
			}
		}
		visited[R - 1][0] = true;
		dfs(R - 1, 0, 1);
		System.out.println(cnt);
	}

	public static void dfs(int x, int y, int d) {
		if (x == 0 && y == C - 1) {
			if (d == K) {
				cnt++;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int dx = nx[i] + x;
			int dy = ny[i] + y;
			if (isPossible(dx, dy) && !visited[dx][dy]) {
				visited[dx][dy] = true;
				dfs(dx, dy, d + 1);
				visited[dx][dy] = false;
			}

		}
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= R || y < 0 || y >= C)
			return false;
		if (arr[x][y] == -1)
			return false;
		return true;

	}

}
