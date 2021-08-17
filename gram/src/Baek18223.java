import java.util.*;
import java.io.*;

class Node18223 implements Comparable<Node18223> {

	int edge;
	int d;

	public Node18223(int edge, int d) {
		this.edge = edge;
		this.d = d;
	}

	@Override
	public int compareTo(Node18223 arg0) {
		return this.d - arg0.d;
	}

}

public class Baek18223 {
	static int V;
	static int E;
	static ArrayList<ArrayList<Node18223>> adjlist;
	static int[][] D;
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		D = new int[2][V + 1];
		adjlist = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			adjlist.add(new ArrayList<>());
			D[0][i] = INF;
			D[1][i] = INF;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			adjlist.get(s).add(new Node18223(e, d));
			adjlist.get(e).add(new Node18223(s, d));
		}

		dijkstra(1, 0);
		dijkstra(end, 1);
		if (D[0][V] >= D[0][end] + D[1][V]) {
			System.out.println("SAVE HIM");
		} else {
			System.out.println("GOOD BYE");
		}
	}

	public static void dijkstra(int start, int go) {
		PriorityQueue<Node18223> pq = new PriorityQueue<>();
		pq.offer(new Node18223(start, 0));
		D[go][start] = 0;

		while (!pq.isEmpty()) {
			Node18223 preNode = pq.poll();
			int preIdx = preNode.edge;
			int preD = preNode.d;
			if (preD > D[go][preIdx])
				continue;

			for (Node18223 nextNode : adjlist.get(preIdx)) {
				if (D[go][nextNode.edge] > nextNode.d + D[go][preIdx]) {
					D[go][nextNode.edge] = nextNode.d + D[go][preIdx];
					pq.offer(new Node18223(nextNode.edge, D[go][nextNode.edge]));
				}
			}

		}

	}

}
