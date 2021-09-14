import java.util.*;
import java.io.*;

public class Baek17779 {

	static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int[][] population;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		population = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int min = 987654321;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				for (int D1 = 1; D1 <= j; D1++) {
					for (int D2 = 1; D2 < N - j; D2++) {
						if (isPossible(i, j, D1, D2, N)) {
							Position[] pos = new Position[4];
							pos[0] = new Position(i, j);
							pos[1] = new Position(i + D1, j - D1);
							pos[2] = new Position(i + D2, j + D2);
							pos[3] = new Position(i + D1 + D2, j - D1 + D2);
							int ret = mapping(pos, N);
							min = Math.min(ret, min);
						}
					}
				}
			}
		}
		System.out.println(min);
	}

	public static int mapping(Position[] pos, int N) {
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(map[i], 5);
		int minus = 0;

		for (int i = 0; i < pos[1].x; i++) {
			if (i >= pos[0].x) {
				minus++;
			}
			for (int j = 0; j <= pos[0].y - minus; j++) {
				map[i][j] = 1;
			}
		}
		int plus = 0;
		for (int i = 0; i <= pos[2].x; i++) {
			if (i > pos[0].x)
				plus++;
			for (int j = pos[0].y + 1 + plus; j < N; j++) {
				map[i][j] = 2;
			}
		}
		minus = 0;
		for (int i = N - 1; i >= pos[1].x; i--) {
			if (i < pos[3].x)
				minus++;
			for (int j = 0; j < pos[3].y - minus; j++) {
				map[i][j] = 3;
			}
		}
		plus = 0;
		for (int i = N - 1; i > pos[2].x; i--) {
			if (i <= pos[3].x)
				plus++;
			for (int j = pos[3].y + plus; j < N; j++) {
				map[i][j] = 4;
			}
		}
		return retMin(map, N);
	}

	public static int retMin(int[][] map, int N) {
		int one = 0;
		int two = 0;
		int thr = 0;
		int fou = 0;
		int fiv = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					one += population[i][j];
				} else if (map[i][j] == 2) {
					two += population[i][j];
				} else if (map[i][j] == 3) {
					thr += population[i][j];
				} else if (map[i][j] == 4) {
					fou += population[i][j];
				} else {
					fiv += population[i][j];
				}
			}
		}

		int max = Math.max(one, Math.max(two, Math.max(thr, Math.max(fou, fiv))));
		int min = Math.min(one, Math.min(two, Math.min(thr, Math.min(fou, fiv))));
		return max - min;
	}

	public static boolean isPossible(int x, int y, int d1, int d2, int N) {

		if (x + d1 >= N || y - d1 < 0)
			return false;
		if (x + d2 >= N || y + d2 >= N)
			return false;
		if (x + d1 + d2 >= N || y - d1 + d2 >= N)
			return false;
		if (y + d2 - d1 < 0)
			return false;
		return true;
	}

}
