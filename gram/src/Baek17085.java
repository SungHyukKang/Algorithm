import java.util.*;
import java.io.*;

public class Baek17085 {
	static int N;
	static int M;
	static char[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static ArrayList<int[]> list = new ArrayList<>();
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '#') {
					int size = 0;
					Queue<int[]> q = new LinkedList<>();
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx < 0 || nx >= N || ny < 0 || ny >= M)
							break;
						if (map[nx][ny] == '#')
							q.offer(new int[] { nx, ny });
					}
					if (q.size() == 4) {
						while (q.size() == 4) {
							for (int k = 0; k < 4; k++) {
								int[] a = q.poll();
								int nx = a[0] + dx[k];
								int ny = a[1] + dy[k];
								if (nx < 0 || nx >= N || ny < 0 || ny >= M)
									continue;
								if (map[nx][ny] == '#')
									q.offer(new int[] { nx, ny });
							}
							size++;
						}
						list.add(new int[] { i, j, size * 4 + 1 });
					}
				}
			}
		}
		if (list.size() == 0) {
			System.out.println(1);
		} else if (list.size() == 1) {
			System.out.println(list.get(0)[2]);
		} else
			dfs();
	}

	public static void dfs() {
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] a = list.get(i);
			int x = a[0];
			int y = a[1];
			int s = a[2];
			int size = 1;
			int cnt = 1;
			visited = new boolean[N][M];
			visited[x][y] = true;
			while (s >= size) {
				for (int j = i; j < list.size(); j++) {
					if (i == j)
						continue;
					int[] b = list.get(j);
					max = Math.max(max, size * isPossible(b));
				}
				if (s != size)
					for (int k = 0; k < 4; k++) {
						visited[x + dx[k] * cnt][y + dy[k] * cnt] = true;
					}
				cnt++;
				size += 4;
			}
			visited[x][y] = false;
		}
		System.out.println(max);
	}

	public static int isPossible(int[] arr) {
		int x = arr[0];
		int y = arr[1];
		int size = arr[2];
		int s = 1;
		int cnt = 1;
		while (size >= s) {
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i] * cnt;
				int ny = y + dy[i] * cnt;
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
					return s;
				}
			}
			cnt++;
			s += 4;
		}
		return size;
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(visited[i][j] ? "1 " : "0 ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------");
	}

}