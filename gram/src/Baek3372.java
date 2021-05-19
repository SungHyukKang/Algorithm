import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Baek3372 {
	static int N;
	static int[][] map;
	static String[][] dp;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new String[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], "-1");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(dfs(0, 0));
		bw.flush();
		bw.close();
		br.close();
	}

	public static String dfs(int x, int y) {
		if (x == N - 1 && y == N - 1) {
			return "1";
		}
		if (map[x][y] == 0)
			return "0";
		if (!dp[x][y].equals("-1")) {
			return dp[x][y];
		}
		dp[x][y] = "0";

		for (int i = 0; i < 2; i++) {
			int nx = dx[i] * map[x][y] + x;
			int ny = dy[i] * map[x][y] + y;
			if (isPossible(nx, ny)) {
				dp[x][y] = new BigInteger(dp[x][y]).add(new BigInteger(dfs(nx, ny))).toString();
			}
		}
		return dp[x][y];
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dp[i][j].equals("-1") ? 0 + " " : dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}

}
