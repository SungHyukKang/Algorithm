import java.util.*;
import java.io.*;

public class Baek2252_2 {
	static int N;
	static int M;
	static int[] D;
	static int[] result;
	static ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = new int[N + 1];
		result = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			adjlist.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjlist.get(s).add(e);
			D[e]++;
		}
		topologySort();
	}

	public static void topologySort() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (D[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int idx = q.poll();
			sb.append(idx + " ");
			for (int next : adjlist.get(idx)) {
				D[next]--;
				if (D[next] == 0) {
					q.offer(next);
				}
			}
		}
		System.out.println(sb);
	}

}
