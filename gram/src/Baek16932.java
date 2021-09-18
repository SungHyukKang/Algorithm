import java.util.*;
import java.io.*;

public class Baek16932 {
	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		ArrayList<Pair> zero = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					zero.add(new Pair(i, j));
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		boolean[][] visited = new boolean[N][M];
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					Queue<Pair> q = new LinkedList<>();
					q.offer(new Pair(i, j));
					int cnt = 0;
					while (!q.isEmpty()) {
						Pair p = q.poll();
						int x = p.x;
						int y = p.y;
						map[x][y] = list.size() + 1;
						cnt++;
						for (int z = 0; z < 4; z++) {
							int nx = x + dx[z];
							int ny = y + dy[z];
							if (isPossible(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
								q.offer(new Pair(nx, ny));
								visited[nx][ny] = true;
							}
						}
					}
					list.add(cnt);
				}
			}
		}
		int max = 0;
		for (Pair pair : zero) {
			int cnt = 1;
			HashSet<Integer> hsset = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + pair.x;
				int ny = dy[i] + pair.y;
				if (isPossible(nx, ny) && map[nx][ny] != 0 && !hsset.contains(map[nx][ny] - 1)) {
					cnt += list.get(map[nx][ny] - 1);
					hsset.add(map[nx][ny] - 1);
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return false;

		return true;
	}

}
