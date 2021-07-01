import java.util.*;
import java.io.*;

public class Baek2660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			adjlist.add(new ArrayList<>());
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (s == -1 && e == -1)
				break;
			adjlist.get(s).add(e);
			adjlist.get(e).add(s);
		}
		Queue<int[]> q = new LinkedList<>();
		HashMap<Integer, Integer> hsmap = new HashMap<>();
		int min = 987654321;
		for (int i = 1; i <= N; i++) {
			q.offer(new int[] { i, 0 });
			boolean[] visited = new boolean[N + 1];
			visited[i] = true;
			int max = 0;
			while (!q.isEmpty()) {
				int[] p = q.poll();
				int idx = p[0];
				int depth = p[1];
				max = Math.max(depth, max);
				for (int x : adjlist.get(idx)) {
					if (!visited[x]) {
						q.offer(new int[] { x, depth + 1 });
						visited[x] = true;
					}
				}
			}
			min = Math.min(max, min);
			hsmap.put(i, max);
		}
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int x : hsmap.keySet()) {
			if (hsmap.get(x) == min) {
				cnt++;
				list.add(x);
			}
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(min + " " + cnt + "\n");
		for (int z : list) {
			sb.append(z + " ");
		}
		System.out.println(sb);
	}

}
