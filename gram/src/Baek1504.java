import java.util.*;
import java.io.*;

public class Baek1504 {
	static int N;
	static int E;
	static ArrayList<ArrayList<Node>> adjlist = new ArrayList<>();
	static int[][] D;
	static final int INF = Integer.MAX_VALUE;

	static class Node implements Comparable<Node> {
		int idx;
		int d;

		public Node(int idx, int d) {
			this.idx = idx;
			this.d = d;
		}

		@Override
		public int compareTo(Node arg0) {
			return this.d - arg0.d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		D = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			adjlist.add(new ArrayList<Node>());
			Arrays.fill(D[i], INF);
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			adjlist.get(num).add(new Node(num2, num3));
			adjlist.get(num2).add(new Node(num, num3));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		dijkstra(1, 1);
		dijkstra(v1, v1);
		dijkstra(v2, v2);
		int first = INF;
		if (D[1][v1] != INF && D[v1][v2] != INF && D[v2][N] != INF) {
			first = (D[1][v1] + D[v1][v2] + D[v2][N]);
			first = (first <= 0 || first == INF) ? INF : first;
		}
		int second = INF;
		if (D[1][v2] != INF && D[v2][v1] != INF && D[v1][N] != INF) {
			second = D[1][v2] + D[v2][v1] + D[v1][N];
		}
		int answer = Math.min(first, second);
		System.out.println(answer == INF ? -1 : answer);
	}

	public static void dijkstra(int index, int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		D[index][start] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int idx = cur.idx;
			int d = cur.d;
			if (d > D[index][idx])
				continue;
			for (Node next : adjlist.get(idx)) {
				if (D[index][next.idx] > next.d + D[index][idx]) {
					D[index][next.idx] = next.d + D[index][idx];
					pq.offer(new Node(next.idx, D[index][next.idx]));
				}
			}
		}
	}
}
