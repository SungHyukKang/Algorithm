import java.util.*;
import java.io.*;

public class Baek14676 {
	static int N;
	static int M;
	static int K;
	static ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
	static int[] result;
	static int[] D;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			adjlist.add(new ArrayList<>());
		}
		D = new int[N + 1];
		result = new int[N + 1];
		visited = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjlist.get(s).add(e);
			D[e]++;
		}
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			int build = Integer.parseInt(st.nextToken());
			q.offer(new int[] { com, build });
		}
		topologySort(q);
	}

	public static void topologySort(Queue<int[]> q) throws IOException {
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int com = p[0];
			int build = p[1];
			if (com == 1) {
				if (D[build] == 0) {
					for (int next : adjlist.get(build)) {
						if (D[next] != 0)
							D[next]--;
					}
					visited[build]++;
				} else {
					System.out.println("Lier!");
					return;
				}
			} else {
				if (visited[build] == 0) {
					System.out.println("Lier!");
					return;
				} else {
					if (visited[build] - 1 == 0)
						for (int pre : adjlist.get(build)) {
							D[pre]++;
						}
				}
				visited[build]--;
			}

		}
		System.out.println("King-God-Emperor");
	}

}
