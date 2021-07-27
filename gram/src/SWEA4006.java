import java.util.*;
import java.io.*;

class NodeS4006 implements Comparable<NodeS4006> {
	int s;
	int e;
	int d;

	public NodeS4006(int s, int e, int d) {
		super();
		this.s = s;
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(NodeS4006 arg0) {
		return this.d <= arg0.d ? -1 : 1;
	}
}

public class SWEA4006 {

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
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int z = 1; z <= T; z++) {
			sb.append("#" + z + " ");
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			parent = new int[N + 1];
			for (int i = 1; i <= N; i++)
				parent[i] = i;
			PriorityQueue<NodeS4006> pq = new PriorityQueue<>();
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				pq.offer(new NodeS4006(s, e, d));
			}
			int val = 0;
			while (!pq.isEmpty()) {
				NodeS4006 n = pq.poll();
				int s = n.s;
				int e = n.e;
				int d = n.d;
				int a = find(s);
				int b = find(e);
				if (a == b)
					continue;
				union(s, e);
				val += d;
			}
			sb.append(val + "\n");
		}
		System.out.println(sb);
	}

}
