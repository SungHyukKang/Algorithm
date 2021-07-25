import java.util.*;
import java.io.*;

class Node1185 implements Comparable<Node1185> {
	int s;
	int e;
	int d;

	public Node1185(int s, int e, int d) {
		this.s = s;
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(Node1185 arg0) {
		return this.d <= arg0.d ? -1 : 1;
	}
}

public class Baek1185 {

	static int[] parent;

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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int[] cost = new int[N + 1];
		int startCost = 987654321;
		for (int i = 1; i < cost.length; i++) {
			cost[i] = Integer.parseInt(br.readLine());
			startCost = Math.min(startCost, cost[i]);
		}
		parent = new int[N + 1];
		PriorityQueue<Node1185> pq = new PriorityQueue<>();
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.offer(new Node1185(s, e, d * 2 + cost[s] + cost[e]));
		}
		int val = 0;
		while (!pq.isEmpty()) {
			Node1185 n = pq.poll();
			int s = n.s;
			int e = n.e;
			int d = n.d;

			int a = find(s);
			int b = find(e);
			if (a == b) {
				continue;
			}
			union(s, e);
			val += d;
		}
		System.out.println(val + startCost);
	}

}
