import java.util.*;
import java.io.*;

public class Baek1595 {
	static class Node {
		int idx;
		int d;

		public Node(int idx, int d) {
			this.idx = idx;
			this.d = d;
		}
	}

	static ArrayList<ArrayList<Node>> adjlist = new ArrayList<>();
	static boolean[] visited;
	static int[] D;
	static int max = 0;
	static int maxNode = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i <= 10000; i++)
			adjlist.add(new ArrayList<>());

		String str = "";
		while ((str = br.readLine()) != null) {
			if (str.equals(""))
				break;
			StringTokenizer st = new StringTokenizer(str);
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			adjlist.get(s).add(new Node(e, d));
			adjlist.get(e).add(new Node(s, d));
		}
		visited = new boolean[10001];
		D = new int[10001];
		dfs(1, 0);
		visited = new boolean[10001];
		D = new int[10001];
		max = 0;
		dfs(maxNode, 0);
		System.out.println(max);
	}

	public static void dfs(int start, int sum) {
		if (max < sum) {
			max = sum;
			maxNode = start;
		}
		visited[start] = true;
		for (Node next : adjlist.get(start)) {
			if (!visited[next.idx]) {
				dfs(next.idx, sum + next.d);
			}
		}
	}

}
