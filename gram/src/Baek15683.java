import java.util.*;
import java.io.*;

class Pair15683 {
	int x, y;

	public Pair15683(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Baek15683 {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] cpy;
	static ArrayList<Pair15683> list = new ArrayList<>();
	static boolean[][] visited;
	static int[] size = { 0, 4, 2, 4, 4, 4 };
	static int min = 210000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cpy = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				cpy[i][j] = arr[i][j];
				if (arr[i][j] != 0 && arr[i][j] != 6) {
					list.add(new Pair15683(i, j));
				}
			}
		}
		dfs(0);
		System.out.println(min);
	}

	public static void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == -1)
					System.out.print("-1 ");
				else
					System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("=========================");
	}

	public static void copyMap(int[][] ccpy) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = ccpy[i][j];
			}
		}
	}

	public static void direction(int dir, int x, int y) {
		if (dir == 0) { // 동
			for (int i = y + 1; i < M; i++) {
				if (arr[x][i] == 6)
					break;
				if (arr[x][i] == 0)
					arr[x][i] = -1;
			}
		} else if (dir == 1) { // 남
			for (int i = x + 1; i < N; i++) {
				if (arr[i][y] == 6)
					break;
				if (arr[i][y] == 0)
					arr[i][y] = -1;
			}
		} else if (dir == 2) { // 서
			for (int i = y - 1; i >= 0; i--) {
				if (arr[x][i] == 6)
					break;
				if (arr[x][i] == 0)
					arr[x][i] = -1;
			}

		} else { // 북
			for (int i = x - 1; i >= 0; i--) {
				if (arr[i][y] == 6)
					break;
				if (arr[i][y] == 0)
					arr[i][y] = -1;
			}
		}
	}

	public static void dfs(int cnt) {
		if (cnt == list.size()) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 0)
						count++;
				}
			}
			min = Math.min(count, min);
			return;
		}

		int x = list.get(cnt).x;
		int y = list.get(cnt).y;
		int cctv = arr[x][y];
		int[][] ccpy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ccpy[i][j] = arr[i][j];
			}
		}
		if (arr[x][y] == 1) {
			for (int i = 0; i < size[cctv]; i++) {
				direction(i, x, y);
				dfs(cnt + 1);
				copyMap(ccpy);
			}
		} else if (arr[x][y] == 2) {
			for (int i = 0; i < size[cctv]; i++) {
				direction(i, x, y);
				direction(i + 2, x, y);
				dfs(cnt + 1);
				copyMap(ccpy);
			}
		} else if (arr[x][y] == 3) {
			for (int i = 0; i < size[cctv]; i++) {
				direction(i, x, y);
				direction((i + 1) % 4, x, y);
				dfs(cnt + 1);
				copyMap(ccpy);
			}
		} else if (arr[x][y] == 4) {
			for (int i = 0; i < size[cctv]; i++) {
				direction(i, x, y);
				direction((i + 1) % 4, x, y);
				direction((i + 2) % 4, x, y);
				dfs(cnt + 1);
				copyMap(ccpy);
			}
		} else {
			for (int i = 0; i < size[cctv]; i++) {
				direction(i, x, y);
			}
			dfs(cnt + 1);
		}

	}
}
