import java.util.*;
import java.io.*;

public class Baek14916 {

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] dp = new int[100001];
		Arrays.fill(dp, 999999);
		dp[0] = 0;
		dp[2] = 1;
		dp[4] = 2;
		dp[5] = 1;
		for (int i = 6; i <= N; i++) {
			dp[i] = Math.min(dp[i - 2] + dp[2], dp[i - 5] + dp[5]);
		}
		System.out.println(dp[N] == 999999 ? -1 : dp[N]);
	}

}
