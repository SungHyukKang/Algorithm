import java.util.*;
import java.io.*;

public class SWEA1885 {
	static ArrayList<ArrayList<Integer>> adjlist;
	static int[][] parent;
	static int[] deep;
	static boolean[] visited;
	static int N;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			adjlist = new ArrayList<>();
			list = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				adjlist.add(new ArrayList<>());
			}
			parent = new int[N + 1][20];
			deep = new int[N + 1];
			parent[1][0] = 1;
			visited = new boolean[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 2; i <= N; i++) {
				int p = Integer.parseInt(st.nextToken());
				adjlist.get(p).add(i);
			}
			bfs(1, 0);
			connecting();
			long ans = 0;
			for (int i = 0; i < N - 1; i++) {
				int LCA = LCA(list.get(i), list.get(i + 1));
				long a = deep[list.get(i)] - deep[LCA];
				long b = deep[list.get(i + 1)] - deep[LCA];
				ans += a;
				ans += b;
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	public static void connecting() {
		for (int p = 1; p < 20; p++) {
			for (int cur = 1; cur <= N; cur++) {
				parent[cur][p] = parent[parent[cur][p - 1]][p - 1];
			}
		}
	}

	public static int LCA(int node1, int node2) {
		if (deep[node1] > deep[node2]) {
			int temp = node1;
			node1 = node2;
			node2 = temp;
		}

		for (int i = 19; i >= 0; i--) {
			int jump = 1 << i;
			if (deep[node2] - deep[node1] >= jump)
				node2 = parent[node2][i];
		}

		if (node1 == node2)
			return node1;

		for (int i = 19; i >= 0; i--) {
			if (parent[node1][i] == parent[node2][i])
				continue;
			node1 = parent[node1][i];
			node2 = parent[node2][i];
		}

		return parent[node1][0];
	}

	public static void bfs(int current, int depth) { // 노드의 바로 윗 부모를 parent에 저장한다.
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { current, depth });
		visited[current] = true;

		while (!q.isEmpty()) {
			int[] p = q.poll();
			int cur = p[0];
			int d = p[1];
			deep[cur] = d;
			list.add(cur);
			for (int next : adjlist.get(cur)) {
				if (!visited[next]) {
					parent[next][0] = cur;
					q.offer(new int[] { next, d + 1 });
					visited[next] = true;
				}
			}

		}
	}

}
