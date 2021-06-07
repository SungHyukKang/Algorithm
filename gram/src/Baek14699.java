import java.util.*;
import java.io.*;

public class Baek14699 {
	static int N;
	static int M;
	static int[] dp;
	static int[] D;
	static ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		int minidx = 0;
		int min = 987654321;
		for (int i = 1; i <= N; i++) {
			D[i] = Integer.parseInt(st.nextToken());
			if (min > D[i]) {
				min = D[i];
				minidx = i;
			}
		}

		for (int i = 0; i <= N; i++)
			adjlist.add(new ArrayList<>());
		dp = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (D[s] > D[e]) {
				adjlist.get(e).add(s);
			} else {
				adjlist.get(s).add(e);
			}
		}
		Arrays.fill(dp, -1);
		for (int i = 1; i <= N; i++) {
			dfs(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(dp[i] + "\n");
		}
		System.out.println(sb);

	}

	public static int dfs(int idx) {
		if (adjlist.get(idx).size() == 0) {
			dp[idx] = 1;
			return dp[idx];
		}
		if (dp[idx] != -1)
			return dp[idx];

		for (int next : adjlist.get(idx)) {
			dp[idx] = Math.max(dp[idx], dfs(next) + 1);
		}
		return dp[idx];
	}
}
