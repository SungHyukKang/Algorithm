import java.io.*;
import java.util.StringTokenizer;

public class Baek2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			S[i] = Integer.parseInt(br.readLine());
		}
		if (N == 1) {
			System.out.println(S[1]);
			return;
		}
		int[][] dp = new int[N + 1][3];
		dp[1][1] = S[1];
		dp[2][1] = S[2];
		dp[2][2] = S[1] + S[2];
		int max = 0;
		if (N > 2) {
			for (int i = 3; i <= N; i++) {
				dp[i][1] = Math.max(Math.max(dp[i-1][1],dp[i-1][2]),S[i] + Math.max(dp[i - 2][1], dp[i - 2][2]));
				dp[i][2] = Math.max(Math.max(dp[i-1][2],dp[i-1][1]),S[i] + dp[i - 1][1]);
				int x = Math.max(dp[i][1], dp[i][2]);
				max = Math.max(max, x);
			}
			System.out.println(max);
		} else {
			System.out.println(S[1] + S[2]);
		}

	}

}
