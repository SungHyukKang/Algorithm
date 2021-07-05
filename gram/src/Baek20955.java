import java.util.*;
import java.io.*;

public class Baek20955 {
	static int N;
	static int M;
	static int[] parent;
	static ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();

	public static int find(int a) {
		if (parent[a] == a)
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
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++)
			parent[i] = i;
		for (int i = 0; i <= N; i++)
			adjlist.add(new ArrayList<>());
		int cnt = -1;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjlist.get(s).add(e);
			adjlist.get(e).add(s);

			int a = find(s);
			int b = find(e);
			if (a == b) {
				cnt++;
				continue;
			}
			union(s, e);
		}
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				cnt++;
				Queue<Integer> q = new LinkedList<>();
				q.offer(i);
				visited[i] = true;
				while (!q.isEmpty()) {
					int idx = q.poll();

					for (int next : adjlist.get(idx)) {
						if (!visited[next]) {
							visited[next] = true;
							q.offer(next);
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
