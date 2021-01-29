import java.util.*;
import java.io.*;

public class Baek1520 {
	static int[][] dp;
	static int[][] arr;
	static int[] nx = { 0, 1, 0, -1 };
	static int[] ny = { 1, 0, -1, 0 };
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		dp = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = 0;

		System.out.println(dfs(0, 0));
	}

	public static int dfs(int x, int y) {
//		System.out.println(x+" "+y);
//		print();
		if (x == M - 1 && y == N - 1)
			return 1;
		if (dp[x][y] != 0) 
			return dp[x][y];
		for (int i = 0; i < nx.length; i++) {
			int dx = nx[i] + x;
			int dy = ny[i] + y;
			if (isPossible(dx, dy) && arr[x][y] > arr[dx][dy]) {
				dp[x][y] += dfs(dx, dy);
			}
		}

		return dp[x][y];
	}

	public static void print() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= N)
			return false;
		return true;
	}
}
