import java.util.*;
import java.io.*;

class Pair17144 {
	int x;
	int y;

	public Pair17144(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Baek17144 {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] cpy;
	static Pair17144 up;
	static Pair17144 down;
	static int nx[] = { 0, 1, 0, -1 };
	static int ny[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cpy = new int[N][M];
		boolean tf = true;
		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				cpy[i][j] = arr[i][j];
				if (arr[i][j] == -1 && tf) {
					up = new Pair17144(i, j);
					tf = false;
				} else if (arr[i][j] == -1 && !tf) {
					down = new Pair17144(i, j);
				}
			}
		}
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (cpy[i][j] >= 5) {
						int cnt = 0;
						for (int d = 0; d < nx.length; d++) {
							int dx = nx[d] + i;
							int dy = ny[d] + j;
							if (isPossible(dx, dy) && cpy[dx][dy] != -1) {
								arr[dx][dy] += cpy[i][j] / 5;
								cnt++;
							}
						}
						arr[i][j] -= (cpy[i][j] / 5) * cnt;
					}
				}
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					cpy[i][j] = arr[i][j];
				}
			}
			// 0 : R , 1 : D , 2 : L , 3 : U
			int x = up.x;
			int y = up.y;
			int d = 0;
			for (int v = 0; v < 4; v++) {
				while (true) {
					int dx = nx[d] + x;
					int dy = ny[d] + y;
					if (dx < 0 || dx >= N || dy < 0 || dy >= M || dx > up.x) {
						break;
					}
					if (dx == up.x && dy == up.y) {
						break;
					}
					if (cpy[x][y] != -1) {
						arr[dx][dy] = cpy[x][y];
					} else {
						arr[dx][dy] = 0;
					}
					x = dx;
					y = dy;
				}
				d = upup(d);
			}
			x = down.x;
			y = down.y;
			for (int v = 0; v < 4; v++) {
				while (true) {
					int dx = nx[v] + x;
					int dy = ny[v] + y;
					if (dx < 0 || dx >= N || dy < 0 || dy >= M || dx < down.x) {
						break;
					}
					if (dx == down.x && dy == down.y) {
						break;
					}
					if (cpy[x][y] != -1) {
						arr[dx][dy] = cpy[x][y];
					} else {
						arr[dx][dy] = 0;
					}
					x = dx;
					y = dy;
				}
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					cpy[i][j] = arr[i][j];
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != -1) {
					sum += arr[i][j];
				}
			}
		}
		System.out.println(sum);
	}

	public static int upup(int x) {
		if (x == 0) {
			return 3;
		} else if (x == 1) {
			return 0;
		} else if (x == 2) {
			return 1;
		} else
			return 2;
	}

	public static void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===============================");
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return false;

		return true;
	}
}
