import java.util.*;
import java.io.*;

public class Baek13910 {
	static int[] wok;
	static HashSet<Integer> hsset = new HashSet<>();
	static boolean[] visited;
	static int M;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		wok = new int[M];
		visited = new boolean[M];
		for (int i = 0; i < M; i++) {
			wok[i] = Integer.parseInt(st.nextToken());
			hsset.add(wok[i]);
		}
		int[] dp = new int[N + 1];
		dfs(0, 0);
		for (int x : hsset) {
			dp[x] = 1;
			for (int i = x + 1; i <= N; i++) {
				if (dp[i - x] == 0)
					continue;
				if (dp[i] == 0 || dp[i] > dp[i - x] + 1) {
					dp[i] = dp[i - x] + 1;
				}
			}
		}

		System.out.println(dp[N] == 0 ? "-1" : dp[N]);
	}

	public static void dfs(int cnt, int sum) {
		if (cnt == 2) {
			if (sum <= N)
				hsset.add(sum);
			return;
		}
		for (int i = 0; i < M; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(cnt + 1, sum + wok[i]);
				visited[i] = false;
			}
		}

	}

}
