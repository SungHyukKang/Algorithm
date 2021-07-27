import java.util.*;
import java.io.*;

public class SWEA1248 {

	static int[] parent;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adjlist;
	static ArrayList<ArrayList<Integer>> adjlist2;
	static int p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("#" + test_case + " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjlist = new ArrayList<>();
			adjlist2 = new ArrayList<>();
			parent = new int[V + 1];
			visited = new boolean[V + 1];
			for (int i = 0; i <= V; i++) {
				adjlist.add(new ArrayList<>());
				adjlist2.add(new ArrayList<>());
				parent[i] = i;
			}

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				adjlist.get(e).add(s);
				adjlist2.get(s).add(e);
				parent[e] = s;
			}
			dfs(n1);
			dfs(n2);
			Queue<Integer> q = new LinkedList<>();
			q.offer(p);
			int answer = 1;
			while (!q.isEmpty()) {
				int n = q.poll();
				answer += adjlist2.get(n).size();
				for (int next : adjlist2.get(n)) {
					q.offer(next);
				}
			}
			sb.append(p + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int start) {
		if (visited[start]) {
			p = start;
			return;
		}
		visited[start] = true;
		for (int next : adjlist.get(start)) {
			dfs(next);
		}

	}

}
