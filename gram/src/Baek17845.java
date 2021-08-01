import java.util.*;
import java.io.*;

public class Baek17845 {
	static int N;
	static int M;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[M + 1][N + 1];
		int[] v = new int[M + 1];
		int[] w = new int[M + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			v[i] = value;
			w[i] = weight;
		}
		int answer = 0;
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j <= N; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= w[i]) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
				}
				answer = Math.max(dp[i][j], answer);
			}
		}
		System.out.println(answer);
	}

}
