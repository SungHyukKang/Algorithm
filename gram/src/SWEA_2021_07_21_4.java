
import java.util.*;
import java.io.*;

class Node07214 implements Comparable<Node07214> {
	int e;
	int d;

	public Node07214(int e, int d) {
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(Node07214 arg0) {
		return this.d <= arg0.d ? -1 : 1;
	}

}

class SWEA_2021_07_21_4 {
	private static int N;
	private static int M;
	private static int X;
	private static ArrayList<ArrayList<Node07214>> adjlist;
	private static ArrayList<ArrayList<Node07214>> adjlist2;
	private static final int INF = 987654321;
	private static int[] D;
	private static int[] D2;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			D = new int[N + 1];
			D2 = new int[N + 1];
			adjlist = new ArrayList<>();
			adjlist2 = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				adjlist.add(new ArrayList<>());
				adjlist2.add(new ArrayList<>());
				D[i] = INF;
				D2[i] = INF;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				adjlist.get(s).add(new Node07214(e, d));
				adjlist2.get(e).add(new Node07214(s, d));
			}
			dijkstra(X, adjlist, D);
			dijkstra(X, adjlist2, D2);

			int max = 0;
			for (int i = 1; i <= N; i++) {
				max = Math.max(max, D[i] + D2[i]);
			}
			sb.append("#" + test_case + " " + max + "\n");
		}
		System.out.println(sb);
	}

	public static void dijkstra(int start, ArrayList<ArrayList<Node07214>> adjlist, int[] D) {
		PriorityQueue<Node07214> pq = new PriorityQueue<>();
		D[start] = 0;
		pq.offer(new Node07214(start, 0));

		while (!pq.isEmpty()) {
			Node07214 node = pq.poll();
			int idx = node.e;
			int d = node.d;
			if (d > D[idx])
				continue;

			for (Node07214 next : adjlist.get(idx)) {
				if (D[next.e] > next.d + D[idx]) {
					D[next.e] = next.d + D[idx];
					pq.offer(new Node07214(next.e, D[next.e]));
				}
			}

		}
	}

}