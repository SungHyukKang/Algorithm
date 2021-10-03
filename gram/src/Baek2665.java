import java.util.*;
import java.io.*;

public class Baek2665 {
	static int N;

	static class Node implements Comparable<Node> {
		int x, y, d;

		Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		public int compareTo(Node arg0) {
			return this.d - arg0.d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		int[][] D = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(D[i], Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, 0));
		D[0][0] = 0;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int x = cur.x;
			int y = cur.y;
			int d = cur.d;
			if (x == N - 1 && y == N - 1) {
				System.out.println(d);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (D[nx][ny] <= D[x][y])
					continue;
				if (map[nx][ny] == 1) {
					pq.offer(new Node(nx, ny, d));
					D[nx][ny] = d;
				} else {
					if (D[nx][ny] > d + 1) {
						D[nx][ny] = d + 1;
					}
					pq.offer(new Node(nx, ny, D[nx][ny]));
				}
			}

		}
	}

}
