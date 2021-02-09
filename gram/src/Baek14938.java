import java.util.*;
import java.io.*;

class Node14938 implements Comparable<Node14938> {
	int e;
	int d;

	public Node14938(int e, int d) {
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(Node14938 o) {
		return this.d <= o.d ? -1 : 1;
	}
}

public class Baek14938 {
	static int[][] D;
	static int N;
	static int M;
	static int R;
	static int[] value;

	static ArrayList<ArrayList<Node14938>> list = new ArrayList<>();
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		D = new int[N + 1][N + 1];
		value = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 1; i <= N; i++) {
			Arrays.fill(D[i], INF);
		}
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.get(s).add(new Node14938(e, d));
			list.get(e).add(new Node14938(s, d));
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			dijkstra(i);
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				if (D[i][j] <= M) {
					sum += value[j];
				}
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node14938> pq = new PriorityQueue<Node14938>();
		pq.offer(new Node14938(start, 0));
		D[start][start] = 0;
		while (!pq.isEmpty()) {
			Node14938 n = pq.poll();
			int e = n.e;
			int d = n.d;

			if (d > D[start][e])
				continue;

			for (Node14938 node : list.get(e)) {
				if (D[start][node.e] > node.d + D[start][e]) {
					D[start][node.e] = node.d + D[start][e];
					pq.offer(new Node14938(node.e, D[start][node.e]));
				}
			}
		}
	}
}
