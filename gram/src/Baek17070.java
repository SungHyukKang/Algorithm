import java.util.*;
import java.io.*;

public class Baek17070 {
	static int N;
	static int[][] arr;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N][4];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(0, 1, 1));
	}

	public static int dfs(int x, int y, int dir) {
		if (x == N - 1 && y == N - 1) {
			return 1;
		}
		if (dp[x][y][dir] != 0) {
			return dp[x][y][dir];
		}
		if (dir == 1 || dir == 2) {
			if (isPossible(x, y + 1) && arr[x][y + 1] != 1) {
				dp[x][y][dir] += dfs(x, y + 1, 1);
			}
		}
		if (isPossible(x + 1, y + 1) && arr[x + 1][y + 1] != 1 && arr[x + 1][y] != 1 && arr[x][y + 1] != 1) {
			dp[x][y][dir] += dfs(x + 1, y + 1, 2);
		}
		if (dir == 3 || dir == 2) {
			if (isPossible(x + 1, y) && arr[x + 1][y] != 1) {
				dp[x][y][dir] += dfs(x + 1, y, 3);
			}
		}
		return dp[x][y][dir];
	}

	public static void print(int dir) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(dp[i][j][dir] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}
}
