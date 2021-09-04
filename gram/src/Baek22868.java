import java.util.*;
import java.io.*;

public class Baek22868 {
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> adjlist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjlist = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			adjlist.add(new ArrayList<Integer>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjlist.get(s).add(e);
			adjlist.get(e).add(s);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(adjlist.get(i));
		}
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { S, 0 });
		boolean[] visited = new boolean[N + 1];
		visited[S] = true;
		int[] path = new int[N + 1];
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int cur = p[0];
			int d = p[1];
			if (cur == E) {
				if (S == E) {
					System.out.println(d);
					break;
				}

				visited = new boolean[N + 1];
				visited[E] = true;
				for (int i = E; path[i] != S; i = path[i]) {
					visited[path[i]] = true;
				}
				E = S;
				q.clear();
			}
			for (int next : adjlist.get(cur)) {
				if (!visited[next]) {
					path[next] = cur;
					q.offer(new int[] { next, d + 1 });
					visited[next] = true;
				}
			}
		}
	}

}
