import java.util.*;
import java.io.*;

public class Baek21317 {
	static int[][] arr;
	static int[][] dp;
	static int N;
	static int K;
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][2];
		dp = new int[N + 1][2];
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			arr[i][0] = num1;
			arr[i][1] = num2;
		}
		K = Integer.parseInt(br.readLine());
		for (int i = 1; i < N; i++) {
			dp[i][0] = INF;
			dp[i][1] = INF;
		}
		System.out.println(dfs(1, 0));
	}

	public static int dfs(int idx, int cnt) {
		if (idx == N) {
			return 0;
		}
		if (dp[idx][cnt] < INF)
			return dp[idx][cnt];
		if (cnt == 0 && idx + 3 <= N) {
			dp[idx][cnt] = Math.min(dp[idx][cnt], dfs(idx + 3, 1) + K);
		}

		if (idx + 1 <= N)
			dp[idx][cnt] = Math.min(dp[idx][cnt], dfs(idx + 1, cnt) + arr[idx][0]);
		if (idx + 2 <= N)
			dp[idx][cnt] = Math.min(dp[idx][cnt], dfs(idx + 2, cnt) + arr[idx][1]);

		return dp[idx][cnt];
	}

	public static void print() {
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}

}
