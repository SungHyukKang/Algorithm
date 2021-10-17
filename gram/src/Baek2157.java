import java.util.*;
import java.io.*;

public class Baek2157 {

	static ArrayList<HashMap<Integer, Integer>> adjlist = new ArrayList<>();
	static int[][] dp;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][M + 1];
		for (int i = 0; i <= N; i++) {
			adjlist.add(new HashMap<>());
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (s > e)
				continue;
			if (adjlist.get(s).get(e) != null) {
				if (adjlist.get(s).get(e) > d)
					continue;
			}
			adjlist.get(s).put(e, d);
		}
		System.out.println(dfs(1, 1));
	}

	public static int dfs(int n, int m) {
		if (n == N) {
			return dp[n][m] = 0;
		}
		if (dp[n][m] != -1) {
			return dp[n][m];
		}
		dp[n][m] = Integer.MIN_VALUE;
		for (int next : adjlist.get(n).keySet()) {
			if (next > n && m < M)
				dp[n][m] = Math.max(dp[n][m], dfs(next, m + 1) + adjlist.get(n).get(next));
		}

		return dp[n][m];
	}

}
