import java.util.*;
import java.io.*;

public class Baek21772 {
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, 1, 0, -1, 0 };
	static boolean[][] visited;
	static char[][] map;
	static int R;
	static int C;
	static int T;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		int gr = 0;
		int gc = 0;
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'G') {
					gr = i;
					gc = j;
				}
			}
		}
		dfs(gr, gc, 0, T);
		System.out.println(max);
	}

	public static void dfs(int x, int y, int cnt, int t) {
		max = Math.max(cnt, max);
		if (t == 0) {
			return;
		}
		for (int i = 0; i < 5; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (isPossible(nx, ny) && !visited[nx][ny] && map[nx][ny] != '#') {
				if (map[nx][ny] == 'S') {
					map[nx][ny] = '.';
					dfs(nx, ny, cnt + 1, t - 1);
					map[nx][ny] = 'S';
				} else {
					dfs(nx, ny, cnt, t - 1);
				}
			}
		}
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= R || y < 0 || y >= C)
			return false;
		return true;
	}
}
