import java.util.*;
import java.io.*;

class Node1240 implements Comparable<Node1240> {
	int e;
	int d;

	public Node1240(int e, int d) {
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(Node1240 arg0) {
		return this.d <= arg0.d ? -1 : 1;
	}
}

public class Baek1240 {

	public static ArrayList<ArrayList<Node1240>> adjlist = new ArrayList<>();
	public static boolean[] visited;
	public static boolean tf;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			adjlist.add(new ArrayList<Node1240>());
		}
		visited = new boolean[N + 1];
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			adjlist.get(s).add(new Node1240(e, d));
			adjlist.get(e).add(new Node1240(s, d));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			visited = new boolean[N + 1];
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			tf = false;
			dfs(start, end, 0);
		}
		System.out.println(sb);

	}

	public static void dfs(int start, int end, int sum) {
		if (start == end || tf) {
			if (!tf) {
				sb.append(sum + "\n");
			}
			tf = true;
			return;
		}
		visited[start] = true;
		for (Node1240 n : adjlist.get(start)) {
			if (!visited[n.e]) {
				dfs(n.e, end, sum + n.d);
			}
		}
	}

}
