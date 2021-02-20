import java.util.*;
import java.io.*;

public class Baek2186 {
	static int N;
	static int M;
	static int K;
	static int[] nx = { 0, 1, 0, -1 };
	static int[] ny = { -1, 0, 1, 0 };
	static char[][] ch;
	static int[][][] dp;
	static char[] target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ch = new char[N][M];
		for (int i = 0; i < N; i++) {
			ch[i] = br.readLine().toCharArray();
		}

		target = br.readLine().toCharArray();
		dp = new int[N][M][target.length];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		int max = 0;
		char temp = target[0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (ch[i][j] == temp) {
					max += dfs(i, j, 0);
				}
			}
		}
		System.out.println(max);
	}

	public static int dfs(int x, int y, int pivot) {
		if (pivot == target.length - 1) {
			return 1;
		}
		if (dp[x][y][pivot] != -1) {
			return dp[x][y][pivot];
		}
		dp[x][y][pivot] = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= K; j++) {
				int dx = x + nx[i] * j;
				int dy = y + ny[i] * j;
				if (dx < 0 || dy < 0 || dx >= N || dy >= M)
					continue;
				if (ch[dx][dy] == target[pivot + 1]) {
					dp[x][y][pivot] += dfs(dx, dy, pivot + 1);
				}
			}
		}
		return dp[x][y][pivot];
	}

	public static void print(int idx) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < ch[i].length; j++) {
				System.out.print(dp[i][j][idx] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}

}
