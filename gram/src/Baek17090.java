import java.util.*;
import java.io.*;

public class Baek17090 {
	static int N;
	static int M;
	static char[][] ch;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ch = new char[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			String X = br.readLine();
			for (int j = 0; j < M; j++) {
				ch[i][j] = X.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer += dfs(i, j);
			}
		}
		System.out.println(answer);
	}

	public static int dfs(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return 1;
		if (dp[x][y] != -1) {
			return dp[x][y];
		}
		dp[x][y] = 0;
		if (ch[x][y] == 'R') {
			dp[x][y] = dfs(x, y + 1);
		} else if (ch[x][y] == 'D') {
			dp[x][y] = dfs(x + 1, y);
		} else if (ch[x][y] == 'U') {
			dp[x][y] = dfs(x - 1, y);
		} else {
			dp[x][y] = dfs(x, y - 1);
		}
		return dp[x][y];
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
	}

}
