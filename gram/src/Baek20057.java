import java.util.*;
import java.io.*;

public class Baek20057 {
	static int[][] map;
	static int[][] nx = { { -1, -1, -1, 1, 1, 1, -2, 2, 0 }, { -1, -1, 0, 0, 0, 0, 1, 1, 2 },
			{ -1, -1, -1, 1, 1, 1, -2, 2, 0 }, { -1, -1, 0, 0, 0, 0, 1, 1, -2 } };
	static int[][] ny = { { -1, 0, 1, -1, 0, 1, 0, 0, -2 }, { -1, 1, -2, -1, 1, 2, -1, 1, 0 },
			{ -1, 0, 1, -1, 0, 1, 0, 0, 2 }, { -1, 1, -2, -1, 1, 2, -1, 1, 0 } };
	static int[][] ash = { { 10, 7, 1, 10, 7, 1, 2, 2, 5 }, { 1, 1, 2, 7, 7, 2, 10, 10, 5 },
			{ 1, 7, 10, 1, 7, 10, 2, 2, 5 }, { 10, 10, 2, 7, 7, 2, 1, 1, 5 } };
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}
		int startX = N / 2;
		int startY = N / 2;
		int cnt = 0;
		int dir = 0;
		int pl = 1;
		while (true) {
			if (startX == 0 && startY == 0)
				break;
			for (int i = 0; i < pl; i++) {
				if (startX == 0 && startY == 0)
					break;
				startX += dx[dir];
				startY += dy[dir];
				if (map[startX][startY] == 0)
					continue;
				int[] pair = spread(map, dir, startX, startY);
				int nextX = startX + dx[dir];
				int nextY = startY + dy[dir];
				if (isPossible(nextX, nextY)) {
					map[nextX][nextY] += (map[startX][startY] - pair[0] - pair[1]);
				}
				map[startX][startY] = 0;
			}
			dir++;
			cnt++;
			if (cnt % 2 == 0)
				pl++;
			if (dir % 4 == 0)
				dir = 0;
		}
		System.out.println(sum - print());
	}

	public static int[] spread(int[][] map, int dir, int x, int y) {
		int ashSum = 0;
		int ashMinus = 0;
		for (int i = 0; i < nx[dir].length; i++) {
			int newX = x + nx[dir][i];
			int newY = y + ny[dir][i];
			if (isPossible(newX, newY)) {
				map[newX][newY] += ((map[x][y] * ash[dir][i]) / 100);
				ashMinus += ((map[x][y] * ash[dir][i]) / 100);
			} else {
				ashSum += (map[x][y] * ash[dir][i]) / 100;
			}
		}
		return new int[] { ashSum, ashMinus };
	}

	public static int print() {
		int ret = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ret += map[i][j];
			}
		}
		return ret;
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}

}
