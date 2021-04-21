import java.util.*;
import java.io.*;

public class Baek10844 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][10];
		Arrays.fill(dp[1], 1);
		if (N > 1) {
			Arrays.fill(dp[2], 2);
			dp[2][0] = 1;
			dp[2][9] = 1;
		}
		if (N > 2)
			for (int i = 3; i <= N; i++) {
				for (int j = 0; j <= 9; j++) {
					if (j == 0) {
						dp[i][j] = dp[i - 1][j + 1];
					} else if (j == 9) {
						dp[i][j] = dp[i - 1][j - 1];
					} else {
						dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]);
					}
					dp[i][j] %= 1000000000;
				}
			}
		long sum = 0;
		for (int i = 1; i <= 9; i++) {
			sum = (sum + dp[N][i]) % 1000000000;
		}
		System.out.println(sum);
	}

}
