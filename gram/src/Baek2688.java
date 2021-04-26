import java.io.*;
import java.util.*;

public class Baek2688 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		long[][] dp = new long[65][10];
		Arrays.fill(dp[1], 1);
		for (int i = 2; i <= 64; i++) {
			for (int j = 0; j < 10; j++) {
				for (int z = 0; z <= j; z++) {
					dp[i][j] += dp[i - 1][z];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			long answer = 0;
			for (int i = 0; i < 10; i++) {
				answer += dp[N][i];
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);

	}

}
