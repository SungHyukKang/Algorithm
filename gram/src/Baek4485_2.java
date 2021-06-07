import java.util.*;
import java.io.*;

class Node4485_2 implements Comparable<Node4485_2> {
	int x;
	int y;
	int d;

	public Node4485_2(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	@Override
	public int compareTo(Node4485_2 arg0) {
		return this.d <= arg0.d ? -1 : 1;
	}

}

public class Baek4485_2 {
	static int[][] map;
	static int[][] D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nx = { 0, 1, 0, -1 };
		int[] ny = { 1, 0, -1, 0 };
		StringBuilder sb = new StringBuilder();
		int T = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			D = new int[N][N];
			int INF = 987654321;
			if (N == 0)
				break;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			PriorityQueue<Node4485_2> pq = new PriorityQueue<>();
			pq.offer(new Node4485_2(0, 0, map[0][0]));
			D[0][0] = map[0][0];
			for (int i = 0; i < N; i++)
				Arrays.fill(D[i], INF);
			while (!pq.isEmpty()) {
				Node4485_2 n = pq.poll();
				int x = n.x;
				int y = n.y;
				int d = n.d;
				if (d > D[x][y])
					continue;
				for (int i = 0; i < 4; i++) {
					int dx = nx[i] + x;
					int dy = ny[i] + y;
					if (dx < 0 || dx >= N || dy < 0 || dy >= N)
						continue;
					if (D[dx][dy] > map[dx][dy] + d) {
						D[dx][dy] = map[dx][dy] + d;
						pq.offer(new Node4485_2(dx, dy, D[dx][dy]));
					}
				}
			}
			sb.append("Problem " + T++ + ": " + D[N - 1][N - 1] + "\n");
		}
		System.out.println(sb);
	}

}
