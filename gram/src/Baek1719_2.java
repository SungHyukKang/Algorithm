import java.util.*;
import java.io.*;

class Node1719_2 implements Comparable<Node1719_2> {
	int e;
	int d;

	public Node1719_2(int e, int d) {
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(Node1719_2 arg0) {
		return this.d <= arg0.d ? -1 : 1;
	}
}

public class Baek1719_2 {
	public static ArrayList<ArrayList<Node1719_2>> adjlist = new ArrayList<>();
	public static int[][] D;
	public static int[][] path;
	public static final int INF = 9999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		D = new int[N + 1][N + 1];
		path = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++)
			adjlist.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			adjlist.get(s).add(new Node1719_2(e, d));
			adjlist.get(e).add(new Node1719_2(s, d));
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				Arrays.fill(D[i], INF);
			}
			dijkstra(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (path[j][i] == 0) {
					sb.append("- ");
				} else
					sb.append(path[j][i] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static void dijkstra(int start) {
		PriorityQueue<Node1719_2> pq = new PriorityQueue<>();

		pq.offer(new Node1719_2(start, 0));
		D[start][start] = 0;
		while (!pq.isEmpty()) {
			Node1719_2 n = pq.poll();
			int e = n.e;
			int d = n.d;
			if (d > D[start][e])
				continue;
			for (Node1719_2 node : adjlist.get(e)) {
				if (D[start][node.e] > node.d + D[start][e]) {
					D[start][node.e] = node.d + D[start][e];
					pq.offer(new Node1719_2(node.e, D[start][node.e]));
					path[start][node.e] = e;
				}
			}
		}
	}

}
