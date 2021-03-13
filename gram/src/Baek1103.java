import java.util.*;
import java.io.*;

public class Baek1103 {
	static int N;
	static int M;
	static int[][] dp;
	static int[] nx = { 0, 1, 0, -1 };
	static int[] ny = { 1, 0, -1, 0 };
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String X = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = X.charAt(j);
				if (c == 'H') {
					arr[i][j] = 0;
				} else {
					arr[i][j] = c - '0';
				}
			}
		}

		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(dfs(0, 0));
	}

	public static int dfs(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return 0;
		}
		if (arr[r][c] == 0) {
			return 0;
		}
		if (visited[r][c]) {
			System.out.println("-1");
			System.exit(0);
		}
		if (dp[r][c] != -1) {
			return dp[r][c];
		}
		dp[r][c] = 0;
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int dx = nx[i] * arr[r][c] + r;
			int dy = ny[i] * arr[r][c] + c;
			dp[r][c] = Math.max(dp[r][c], dfs(dx, dy) + 1);
		}
		visited[r][c] = false;
		return dp[r][c];

	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}

}
