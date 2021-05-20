import java.util.*;
import java.io.*;

public class Baek21738 {
	static ArrayList<ArrayList<Integer>> adjlist;
	static boolean[] visited;
	static int t = 0;
	static int S;
	static int P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		adjlist = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++)
			adjlist.add(new ArrayList<>());
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjlist.get(s).add(e);
			adjlist.get(e).add(s);
		}
		visited = new boolean[N + 1];
		int[] D = new int[S];
		for (int i = 1; i <= S; i++) {
			dfs(i, 0);
			D[i - 1] = t;
			t = 0;
		}
		Arrays.sort(D);
		System.out.println(N - (D[0] + D[1] + 1));
	}

	public static void dfs(int idx, int d) {
		if (idx == P) {
			t = d;
			return;
		}
		visited[idx] = true;
		for (int next : adjlist.get(idx)) {
			if (!visited[next]) {
				dfs(next, d + 1);
			}
		}
	}

}
