import java.util.*;
import java.io.*;

public class Baek2026 {
	static int K;
	static int N;
	static int F;
	static boolean[][] friend;
	static int[] friend_cnt;
	static boolean tf;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		friend = new boolean[N + 1][N + 1];
		friend_cnt = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < F; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			friend[s][e] = true;
			friend[e][s] = true;
			friend_cnt[s]++;
			friend_cnt[e]++;
		}
		tf = false;
		for (int i = 1; i <= N; i++) {
			if (friend_cnt[i] < K - 1)
				continue;
			if (tf)
				break;
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
		}

		if (!tf) {
			System.out.println("-1");
		}
	}

	public static boolean isPossible(int nf) {

		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				if (!friend[nf][i])
					return false;
			}
		}
		return true;
	}

	public static void dfs(int start, int depth) {
		if (tf)
			return;
		if (depth == K) {
			tf = true;
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= N; i++) {
				if (visited[i])
					sb.append(i + "\n");
			}
			System.out.println(sb);
			return;
		}
		for (int i = start + 1; i <= N; i++) {
			if (!friend[start][i])
				continue;
			if (!isPossible(i))
				continue;
			visited[i] = true;
			dfs(i, depth + 1);
			visited[i] = false;

		}

	}

}
