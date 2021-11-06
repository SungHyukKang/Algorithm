import java.util.*;
import java.io.*;

public class Baek17212 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		dp[5] = 1;
		dp[6] = 2;
		dp[7] = 1;

		for (int i = 8; i <= N; i++) {
			int o = dp[i - 1] + 1;
			int t = dp[i - 2] + 1;
			int f = dp[i - 5] + 1;
			int s = dp[i - 7] + 1;
			dp[i] = Math.min(o, Math.min(t, Math.min(f, s)));
		}
		System.out.println(dp[N]);
	}

}
