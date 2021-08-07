import java.util.*;
import java.io.*;

public class SWEA1249 {
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N;
	static int[][] D;
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			D = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] X = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = X[j] - '0';
				}
			}
			for (int i = 0; i < N; i++)
				Arrays.fill(D[i], INF);
			dijkstra();
			sb.append("#" + t + " " + D[N - 1][N - 1] + "\n");
		}
		System.out.println(sb);
	}

	public static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[2] <= o2[2] ? -1 : 1);
		D[0][0] = 0;
		pq.offer(new int[] { 0, 0, 0 });

		while (!pq.isEmpty()) {
			int[] p = pq.poll();
			int x = p[0];
			int y = p[1];
			int d = p[2];
			if (d > D[x][y])
				continue;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isPossible(nx, ny) && D[nx][ny] > map[nx][ny] + d) {
					D[nx][ny] = map[nx][ny] + d;
					pq.offer(new int[] { nx, ny, D[nx][ny] });
				}
			}
		}
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;

		return true;
	}

}
