import java.util.*;
import java.io.*;

public class Baek1516 {
	static ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
	static int[] w;
	static int[] D;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i <= N; i++) {
			adjlist.add(new ArrayList<>());
		}
		result = new int[N + 1];
		w = new int[N + 1];
		D = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int work = Integer.parseInt(st.nextToken());
			w[i] = work;
			while (st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				if (x == -1)
					break;
				adjlist.get(x).add(i);
				D[i]++;
			}
		}
		topologySort();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++)
			sb.append(result[i] + "\n");
		System.out.println(sb.toString());
	}

	public static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < D.length; i++) {
			if (D[i] == 0) {
				q.offer(i);
			}
			result[i] = w[i];
		}

		for (int i = 1; i < D.length; i++) {
			if (q.isEmpty())
				break;
			int x = q.poll();
			for (int c : adjlist.get(x)) {
				D[c]--;
				result[c] = Math.max(result[c], w[c] + result[x]);
				if (D[c] == 0)
					q.offer(c);
			}

		}

	}

}
