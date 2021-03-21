import java.util.*;
import java.io.*;

public class Baek4803 {
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> adjlist;
	static boolean[] visited;
	static boolean tf;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			adjlist = new ArrayList<>();
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;
			visited = new boolean[N + 1];
			for (int i = 0; i <= N; i++)
				adjlist.add(new ArrayList<>());

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				adjlist.get(s).add(e);
				adjlist.get(e).add(s);
			}
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					tf = false;
					dfs(0, i);
					if (!tf) {
						cnt++;
					}
				}
			}
			if (cnt == 0) {
				sb.append("Case " + T + ": No trees.\n");
			} else if (cnt == 1) {
				sb.append("Case " + T + ": There is one tree.\n");
			} else {
				sb.append("Case " + T + ": A forest of " + cnt + " trees.\n");
			}
			T++;
		}
		System.out.println(sb);
	}

	public static void dfs(int bef, int pre) {
		visited[pre] = true;
		for (int e : adjlist.get(pre)) {
			if (e != bef) {
				if (!visited[e])
					dfs(pre, e);
				else {
					tf = true;
				}
			}
		}
		return;
	}
}
