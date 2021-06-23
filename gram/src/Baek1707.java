import java.util.*;
import java.io.*;

public class Baek1707 {
	static ArrayList<ArrayList<Integer>> adjlist;
	static int RED = 1;
	static int BLUE = -1;
	static int[] colors;
	static boolean tf;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			adjlist = new ArrayList<>();
			for (int i = 0; i <= v; i++) {
				adjlist.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < edge; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				adjlist.get(s).add(e);
				adjlist.get(e).add(s);
			}
			colors = new int[v + 1];
			tf = true;
			for (int i = 1; i <= v; i++) {
				if (!tf) {
					break;
				}
				if (colors[i] == 0) {
					Queue<Integer> q = new LinkedList<>();
					q.offer(i);
					colors[i] = RED;
					bfs(q);
				}
			}
			sb.append(tf ? "YES\n" : "NO\n");
		}
		System.out.println(sb);
	}

	public static void bfs(Queue<Integer> q) {
		while (!q.isEmpty()) {
			int v = q.poll();

			for (int next : adjlist.get(v)) {
				if (colors[next] == 0) {
					colors[next] = colors[v] * -1;
					q.offer(next);
				} else if (colors[next] == colors[v]) {
					tf = false;
					return;
				}
			}
		}
	}
}
