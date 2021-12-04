import java.util.*;
import java.io.*;

public class Baek2623 {
	static int N;
	static int M;
	static int[] D;
	static ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N; i++) {
			adjlist.add(new ArrayList<>());
		}
		D = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextElement();
			int pre = Integer.parseInt(st.nextToken());
			while (st.hasMoreElements()) {
				int num = Integer.parseInt(st.nextToken());
				adjlist.get(pre).add(num);
				D[num]++;
				pre = num;
			}
		}
		topologySort();
		System.out.println(cnt == N ? sb : 0);
	}

	public static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (D[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append("\n");
			cnt++;
			for (int next : adjlist.get(cur)) {
				D[next]--;
				if (D[next] == 0) {
					q.offer(next);
				}
			}
		}

	}

}
