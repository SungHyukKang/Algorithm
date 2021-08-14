import java.util.*;
import java.io.*;

class Node1922_2 implements Comparable<Node1922_2> {
	int s, e, d;

	public Node1922_2(int s, int e, int d) {
		this.s = s;
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(Node1922_2 arg0) {
		return this.d - arg0.d;
	}
}

public class Baek1922_2 {

	static int[] parent;
	static PriorityQueue<Node1922_2> pq = new PriorityQueue<>();
	static int N;
	static int M;

	public static int find(int a) {
		if (a == parent[a])
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}

	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot) {
			parent[aRoot] = b;
		} else
			return;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.offer(new Node1922_2(s, e, d));
		}

		int sum = 0;
		while (!pq.isEmpty()) {
			Node1922_2 nd = pq.poll();
			int s = nd.s;
			int e = nd.e;
			int d = nd.d;

			int a = find(s);
			int b = find(e);
			if (a == b)
				continue;
			union(s, e);
			sum += d;
		}
		System.out.println(sum);

	}

}
