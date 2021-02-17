import java.util.*;
import java.io.*;

public class Baek2056 {
	static ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
	static int[] D;
	static int[] w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		D = new int[N + 1];
		w = new int[N + 1];
		for (int i = 0; i <= N; i++)
			adjlist.add(new ArrayList<>());

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int work = Integer.parseInt(st.nextToken());
			w[i] = work;
			int pre = Integer.parseInt(st.nextToken());
			for (int j = 0; j < pre; j++) {
				int n = Integer.parseInt(st.nextToken());
				adjlist.get(n).add(i);
				D[i]++;
			}
		}
		System.out.println(topologySort());
	}

	public static int topologySort() {
		Queue<Integer> q = new LinkedList<>();
		int max = 0;
		int[] result = new int[D.length];
		for (int i = 1; i < D.length; i++) {
			result[i] = w[i];
			if (D[i] == 0) {
				q.offer(i);
			}
		}
		for (int i = 1; i < D.length; i++) {
			if (q.isEmpty())
				break;
			int x = q.poll();
			for (int n : adjlist.get(x)) {
				D[n]--;
				result[n] = Math.max(result[n], result[x] + w[n]);
				if (D[n] == 0) {
					q.offer(n);
				}
			}
		}
		for (int i = 1; i < w.length; i++) {
			max = Math.max(max, result[i]);
		}

		return max;
	}
}
