import java.util.*;
import java.io.*;

public class Baek13699 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[36];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < i / 2; j++) {
				dp[i] += 2 * dp[j] * dp[i - j - 1];
			}
			if (i % 2 == 1) {
				dp[i] += dp[i / 2] * dp[i / 2];
			}
		}
		System.out.println(dp[N]);
	}

}
