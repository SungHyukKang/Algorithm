import java.util.*;
import java.io.*;

class Node20010 implements Comparable<Node20010> {
	int s;
	int e;
	int d;

	public Node20010(int s, int e, int d) {
		this.s = s;
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(Node20010 arg0) {
		return this.d <= arg0.d ? -1 : 1;
	}

}

public class Baek20010 {
	static int N;
	static int M;
	static ArrayList<ArrayList<Node20010>> adjlist = new ArrayList<>();
	static boolean[] visited;
	static int max = 0;

	public static int find(int a, int[] parent) {
		if (a == parent[a])
			return a;
		parent[a] = find(parent[a], parent);
		return parent[a];
	}

	public static void union(int a, int b, int[] parent) {
		int aRoot = find(a, parent);
		int bRoot = find(b, parent);
		if (aRoot != bRoot) {
			parent[aRoot] = b;
		} else
			return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		visited = new boolean[N];
		PriorityQueue<Node20010> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.offer(new Node20010(s, e, d));
		}
		int sum = 0;

		for (int i = 0; i < N; i++)
			adjlist.add(new ArrayList<>());

		while (!pq.isEmpty()) {
			Node20010 n = pq.poll();
			int s = n.s;
			int e = n.e;
			int d = n.d;
			int a = find(s, parent);
			int b = find(e, parent);
			if (a == b)
				continue;
			union(s, e, parent);
			adjlist.get(s).add(new Node20010(-1, e, d));
			adjlist.get(e).add(new Node20010(-1, s, d));
			sum += d;
		}
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			dfs(0, i);
		}
		System.out.println(sum);
		System.out.println(max);
	}

	public static void dfs(int sum, int idx) {
		visited[idx] = true;
		for (Node20010 n : adjlist.get(idx)) {
			if (!visited[n.e]) {
				dfs(sum + n.d, n.e);
			}
		}
		max = Math.max(max, sum);
	}

}
