import java.util.*;
import java.io.*;

public class Baek20419 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();
		Queue<int[]> q = new LinkedList<>();
		boolean[][][][] visited = new boolean[R][C][K + 1][K + 1];
		visited[0][0][K][K] = true;
		q.offer(new int[] { 0, 0, K, K });
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		// R , D , L , U
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];
			int left = p[2];
			int right = p[3];
			int d = dir(map[x][y]);
			int nx = dx[d] + x;
			int ny = dy[d] + y;
			if (x == R - 1 && y == C - 1) {
				System.out.println("Yes");
				return;
			}
			if (isPossible(nx, ny, R, C) && !visited[nx][ny][left][right]) {
				q.offer(new int[] { nx, ny, left, right });
				visited[nx][ny][left][right] = true;
			}
			if (left == 1) {
				nx = dx[dirLeft(map[x][y])] + x;
				ny = dy[dirLeft(map[x][y])] + y;
				if (isPossible(nx, ny, R, C) && !visited[nx][ny][0][right]) {
					q.offer(new int[] { nx, ny, 0, right });
					visited[nx][ny][0][right] = true;
				}
			}
			if (right == 1) {
				nx = dx[dirRight(map[x][y])] + x;
				ny = dy[dirRight(map[x][y])] + y;
				if (isPossible(nx, ny, R, C) && !visited[nx][ny][left][0]) {
					q.offer(new int[] { nx, ny, left, 0 });
					visited[nx][ny][left][0] = true;
				}
			}
		}
		System.out.println("No");
	}

	public static int dir(char d) {
		if (d == 'R') {
			return 0;
		} else if (d == 'D')
			return 1;
		else if (d == 'L')
			return 2;
		else
			return 3;
	}

	public static int dirRight(char d) {
		if (d == 'R') {
			return 1;
		} else if (d == 'U') {
			return 0;
		} else if (d == 'L') {
			return 3;
		} else {
			return 2;
		}
	}

	public static int dirLeft(char d) {
		if (d == 'R') {
			return 3;
		} else if (d == 'U') {
			return 2;
		} else if (d == 'L') {
			return 1;
		} else {
			return 0;
		}
	}

	public static boolean isPossible(int x, int y, int R, int C) {
		if (x < 0 || x >= R || y < 0 || y >= C) {
			return false;
		}
		return true;
	}

}
