import java.util.*;
import java.io.*;

public class Baek2021 {

	static int N;
	static ArrayList<ArrayList<Integer>> adjlist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		adjlist = new ArrayList<>();
		for (int i = 0; i <= N + L + 1; i++) {
			adjlist.add(new ArrayList<>());
		}
		for (int i = N + 1; i < L + N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int e = Integer.parseInt(st.nextToken());
				if (e == -1)
					break;
				adjlist.get(i).add(e);
				adjlist.get(e).add(i);
			}
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Queue<int[]> pq = new LinkedList<int[]>();
		boolean[] visited = new boolean[N + L + 1];
		for (int x : adjlist.get(start)) {
			visited[x] = true;
			for (int next : adjlist.get(x)) {
				if (visited[next])
					continue;
				visited[next] = true;
				pq.offer(new int[] { next, 0 });
			}
		}
		int ans = -1;
		while (!pq.isEmpty()) {
			int[] p = pq.poll();
			int pre = p[0];
			int d = p[1];
			if (pre == end) {
				ans = d;
				break;
			}
			for (int next : adjlist.get(pre)) {
				if (visited[next])
					continue;
				visited[next] = true;
				for (int nnext : adjlist.get(next)) {
					if (visited[nnext])
						continue;
					visited[nnext] = true;
					pq.offer(new int[] { nnext, d + 1 });
				}
			}

		}
		System.out.println(ans);
	}
}
