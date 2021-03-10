import java.util.*;
import java.io.*;

class Pair6087 {
	int x, y, dir, cnt;

	public Pair6087(int x, int y, int dir, int cnt) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.cnt = cnt;
	}

}

public class Baek6087 {
	static int W;
	static int H;
	static int[][] arr;
	static int[][] D;
	static int[] nx = { 0, 1, 0, -1 };
	static int[] ny = { 1, 0, -1, 0 };
	static int min = 987654321;
	static Queue<Pair6087> q = new LinkedList<>();
	static int tx;
	static int ty;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		D = new int[H][W];
		for (int i = 0; i < H; i++)
			Arrays.fill(D[i], 987654321);
		for (int i = 0; i < H; i++) {
			String X = br.readLine();
			for (int j = 0; j < W; j++) {
				if (X.charAt(j) == '*') {
					arr[i][j] = -1;
				} else if (X.charAt(j) == 'C') {
					arr[i][j] = 1;
				}
			}
		}
		boolean flag = true;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (arr[i][j] == 1) {
					if (flag) {
						q.offer(new Pair6087(i, j, -1, -1));
						D[i][j] = 0;
						flag = false;
					} else {
						tx = i;
						ty = j;
					}
				}
			}
		}
		bfs();
		System.out.println(D[tx][ty]);
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Pair6087 p = q.poll();
			int x = p.x;
			int y = p.y;
			int dir = p.dir;
			int cnt = p.cnt;
			for (int i = 0; i < 4; i++) {
				int dx = nx[i] + x;
				int dy = ny[i] + y;
				int newCnt = cnt;
				if (isPossible(dx, dy) && arr[dx][dy] != -1) {
					newCnt = i == dir ? newCnt : newCnt + 1;
					if (D[dx][dy] >= newCnt) {
						D[dx][dy] = newCnt;
						q.offer(new Pair6087(dx, dy, i, newCnt));
					}
				}
			}

		}
	}

	public static void print() {
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D[i].length; j++) {
				System.out.print(D[i][j] == 987654321 ? "INF " : D[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= H || y < 0 || y >= W) {
			return false;
		}
		return true;
	}

}
