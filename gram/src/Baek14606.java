import java.io.*;

public class Baek14606 {
	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		dp = new int[11];
		dp[1] = 0;
		dp[2] = 1;
		for (int i = 3; i <= N; i++) {
			dp[i] = i / 2 * (i - i / 2) + dp[i / 2] + dp[i - i / 2];
		}
		System.out.println(dp[N]);

	}

}
