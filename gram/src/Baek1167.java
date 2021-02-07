import java.util.*;
import java.io.*;

class Node1167 {
	int e;
	int d;

	public Node1167(int e, int d) {
		this.e = e;
		this.d = d;
	}

}

public class Baek1167 {
	static int V;
	static ArrayList<ArrayList<Node1167>> list = new ArrayList<>();
	static boolean[] visited;
	static int max = 0;
	static int v1;
	static int max2 = 0;
	static int v2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}
		visited = new boolean[V + 1];
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			while (true) {
				int e = Integer.parseInt(st.nextToken());
				if (e == -1)
					break;
				int d = Integer.parseInt(st.nextToken());
				list.get(s).add(new Node1167(e, d));
			}
		}
		int root = 0;
		for (int i = 1; i <= V; i++) {
			if (list.get(i).size() == 1) {
				root = i;
				break;
			}
		}

		dfs(root, 0);
		visited[root] = true;
		visited = new boolean[V + 1];
		visited[v1] = true;
		dfs2(v1, 0);
		System.out.println(max2);

	}

	public static void dfs2(int v, int sum) {
		if (max2 < sum) {
			max2 = sum;
			v2 = v;
		}
		for (Node1167 n : list.get(v)) {
			if (!visited[n.e]) {
				visited[n.e] = true;
				dfs2(n.e, sum + n.d);
			}
		}
	}

	public static void dfs(int v, int sum) {
		if (max < sum) {
			max = sum;
			v1 = v;
		}
		for (Node1167 n : list.get(v)) {
			if (!visited[n.e]) {
				visited[n.e] = true;
				dfs(n.e, sum + n.d);
			}
		}
	}

}
