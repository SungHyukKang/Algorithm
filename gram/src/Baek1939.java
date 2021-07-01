import java.util.*;
import java.io.*;

class Node1939 {
	int e;
	int d;

	public Node1939(int e, int d) {
		this.e = e;
		this.d = d;
	}

}

public class Baek1939 {
	static int N;
	static int M;
	static ArrayList<ArrayList<Node1939>> adjlist = new ArrayList<>();
	static int max;
	static boolean[] visited;
	static int start, end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N; i++)
			adjlist.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			adjlist.get(s).add(new Node1939(e, d));
			adjlist.get(e).add(new Node1939(s, d));
			max = Math.max(max, d);
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		int left = 0;
		int right = max;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (bfs(mid)) {
				left = mid + 1;
			} else
				right = mid - 1;
		}
		System.out.println(right);
	}

	public static boolean bfs(int preCost) {
		visited = new boolean[N + 1];
		visited[start] = true;
		Queue<Node1939> q = new LinkedList<>();
		q.offer(new Node1939(start, 0));
		while (!q.isEmpty()) {
			Node1939 n = q.poll();
			int idx = n.e;
			if (idx == end)
				return true;

			for (Node1939 nd : adjlist.get(idx)) {
				if (!visited[nd.e] && nd.d >= preCost) {
					q.offer(new Node1939(nd.e, nd.d));
					visited[nd.e] = true;
					
				}
			}

		}
		return false;
	}

}
