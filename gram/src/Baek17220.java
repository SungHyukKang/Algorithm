import java.util.*;
import java.io.*;

public class Baek17220 {
	static ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
	static int[] D;
	static int N;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Character, Integer> hsmap = new HashMap<>();
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		D = new int[N];
		for (int i = 0; i < N; i++) {
			hsmap.put((char) ('A' + i), i);
			adjlist.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = hsmap.get(st.nextToken().charAt(0));
			int e = hsmap.get(st.nextToken().charAt(0));
			adjlist.get(s).add(e);
			D[e]++;
		}
		int start = 0;
		for (int i = 0; i < N; i++) {
			if (D[i] == 0) {
				q.offer(i);
			}
		}
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < k; i++) {
			char c = st.nextToken().charAt(0);
			D[hsmap.get(c)] = -1;
			for (int node : adjlist.get(hsmap.get(c))) {
				D[node]--;
			}
		}
		System.out.println(topologySort(start));
	}

	public static int topologySort(int start) {
		int ans = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (D[cur] < 0)
				continue;
			for (int next : adjlist.get(cur)) {
				if (D[next] < 0)
					continue;
				D[next]--;
				if (D[next] == 0) {
					q.offer(next);
					ans++;
				}
			}

		}

		return ans;
	}

}
