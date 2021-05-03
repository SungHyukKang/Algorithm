import java.io.*;

public class Baek15988 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long[] dp = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 1000000; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
		}
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N] + "\n");
		}
		System.out.println(sb);
	}

}
