import java.util.*;
import java.io.*;

class Node5972 implements Comparable<Node5972> {
	int e, d;

	public Node5972(int e, int d) {
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(Node5972 arg0) {
		return this.d <= arg0.d ? -1 : 1;
	}

}

public class Baek5972 {
	static int N;
	static int M;
	static int[] D;
	static ArrayList<ArrayList<Node5972>> list = new ArrayList<>();
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			D[i] = INF;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.get(s).add(new Node5972(e, d));
			list.get(e).add(new Node5972(s, d));
		}
		dijkstra(1);
		System.out.println(D[N]);
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node5972> pq = new PriorityQueue<Node5972>();
		pq.offer(new Node5972(start, 0));
		D[start] = 0;
		while (!pq.isEmpty()) {
			Node5972 nd = pq.poll();
			int idx = nd.e;
			int d = nd.d;

			if (d > D[idx])
				continue;

			for (Node5972 n : list.get(idx)) {
				if (D[n.e] > D[idx] + n.d) {
					D[n.e] = D[idx] + n.d;
					pq.offer(new Node5972(n.e, D[n.e]));
				}
			}

		}
	}

}
