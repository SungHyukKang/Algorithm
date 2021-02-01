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
	static ArrayList<Pair15683> list = new ArrayList<>();
	static int min = 210000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0 && arr[i][j] != 6) {
					list.add(new Pair15683(i, j));
				}
			}
		}
		dfs(0);
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();

	}

	public static void copyMap(int[][] cpy) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = cpy[i][j];
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
		} else if (dir == 1) { // 서
			for (int i = y - 1; i >= 0; i--) {
				if (arr[x][i] == 6)
					break;
				if (arr[x][i] == 0)
					arr[x][i] = -1;
			}
		} else if (dir == 2) { // 남
			for (int i = x + 1; i < N; i++) {
				if (arr[i][y] == 6)
					break;
				if (arr[i][y] == 0)
					arr[i][y] = -1;
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
				for (int j = 0; j < M; j++)
					if (arr[i][j] == 0) {
						count++;
					}
			}
			min = Math.min(min, count);
			return;
		}

		Pair15683 p = list.get(cnt);
		int x = p.x;
		int y = p.y;
		int cctv = arr[x][y];
		int[][] cpy = new int[N][M];
		for (int i = 0; i < cpy.length; i++) {
			for (int j = 0; j < cpy[i].length; j++) {
				cpy[i][j] = arr[i][j];
			}
		}

		if (cctv == 1) {
			for (int i = 0; i < 4; i++) {
				direction(i, x, y);
				dfs(cnt + 1);
				copyMap(cpy);
			}
		} else if (cctv == 2) {
			for (int i = 0; i < 2; i++) {
				int c = i * 2;
				direction(c, x, y);
				direction(c + 1, x, y);
				dfs(cnt + 1);
				copyMap(cpy);
			}
		} else if (cctv == 3) {
			for (int i = 0; i < 4; i++) {
				direction(i % 2, x, y);
				direction(i < 2 ? 2 : 3, x, y);

				dfs(cnt + 1);
				copyMap(cpy);
			}
		} else if (cctv == 4) {
			for (int i = 0; i < 4; i++) {
				direction(i, x, y);
				direction((i + 1) % 4, x, y);
				direction((i + 2) % 4, x, y);
				dfs(cnt + 1);
				copyMap(cpy);
			}
		} else {
			for (int i = 0; i < 4; i++) {
				direction(i, x, y);
			}
			dfs(cnt + 1);
		}

	}

}
