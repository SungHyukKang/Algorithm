import java.util.*;
import java.io.*;

public class Baek1005 {
	static ArrayList<ArrayList<Integer>> adjlist;
	static int[] w;
	static int[] result;
	static int[] D;
	static int fin;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			adjlist = new ArrayList<>();
			for (int i = 0; i <= N; i++)
				adjlist.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			w = new int[N + 1];
			result = new int[N + 1];
			D = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				int cc = Integer.parseInt(st.nextToken());

				w[i] = cc;
				result[i] = cc;
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				adjlist.get(s).add(e);
				D[e]++;
			}
			fin = Integer.parseInt(br.readLine());
			topologySort();
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < D.length; i++) {
			if (D[i] == 0)
				q.offer(i);
		}

		for (int i = 1; i < D.length; i++) {
			if (q.isEmpty())
				break;
			int x = q.poll();

			for (int c : adjlist.get(x)) {
				D[c]--;
				result[c] = Math.max(result[c], w[c] + result[x]);
				if (D[c] == 0) {
					q.offer(c);
				}
			}
			if (D[fin] == 0) {
				sb.append(result[fin] + "\n");
				break;
			}
		}

	}
}
