import java.util.*;
import java.io.*;

public class Baek20168 {

	static int N, M, A, B, C;
	static ArrayList<ArrayList<Node>> adjlist = new ArrayList<>();
	static boolean[] visited;
	static int answer = -1;

	static class Node {
		int index;
		int d;

		public Node(int index, int d) {
			super();
			this.index = index;
			this.d = d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			adjlist.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			adjlist.get(s).add(new Node(e, d));
			adjlist.get(e).add(new Node(s, d));
		}
		visited[A] = true;
		dfs(0, A, 0);
		System.out.println(answer);
	}

	public static void dfs(int sum, int cur, int max) {
		if (cur == B) {
			if (answer == -1) {
				answer = max;
				return;
			}
			answer = Math.min(answer, max);
			return;
		}

		for (Node next : adjlist.get(cur)) {
			if (!visited[next.index] && sum + next.d <= C) {
				visited[next.index] = true;
				dfs(sum + next.d, next.index, max > next.d ? max : next.d);
				visited[next.index] = false;
			}
		}

	}

}
