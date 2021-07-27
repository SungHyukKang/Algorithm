import java.util.*;
import java.io.*;

class NodeS1251 implements Comparable<NodeS1251> {
	int s;
	int e;
	long d;

	public NodeS1251(int s, int e, long d) {
		this.s = s;
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(NodeS1251 arg0) {
		return this.d <= arg0.d ? -1 : 1;
	}

	@Override
	public String toString() {
		return "NodeS1251 [s=" + s + ", e=" + e + ", d=" + d + "]";
	}

}

public class SWEA1251 {

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
			int[][] arr = new int[N + 1][2];
			parent = new int[N + 1];
			for (int i = 1; i <= N; i++)
				parent[i] = i;
			PriorityQueue<NodeS1251> pq = new PriorityQueue<>();
			StringTokenizer X = new StringTokenizer(br.readLine());
			StringTokenizer Y = new StringTokenizer(br.readLine());
			int idx = 1;
			while (X.hasMoreTokens()) {
				arr[idx][0] = Integer.parseInt(X.nextToken());
				arr[idx][1] = Integer.parseInt(Y.nextToken());
				idx++;
			}
			double E = Double.parseDouble(br.readLine());
			for (int i = 1; i <= N; i++) {
				for (int j = i + 1; j <= N; j++) {
					long xD = (long) (arr[i][0] - arr[j][0]);
					long yD = (long) (arr[i][1] - arr[j][1]);
					long distance = (long) (xD * xD) + (long) (yD * yD);
					pq.offer(new NodeS1251(i, j, distance));
				}
			}
			double val = 0;
			while (!pq.isEmpty()) {
				NodeS1251 n = pq.poll();
				int s = n.s;
				int e = n.e;
				long d = n.d;
				int a = find(s);
				int b = find(e);
				if (a == b)
					continue;
				union(s, e);
				val += d;
			}
			val *= E;
			sb.append(Math.round(val) + "\n");
		}
		System.out.println(sb);
	}

}
