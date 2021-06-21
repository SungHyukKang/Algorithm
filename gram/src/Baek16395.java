import java.util.*;
import java.io.*;

public class Baek16395 {

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[31][31];
		dp[1][1] = 1;

		for (int i = 2; i < 31; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			}
		}
		System.out.println(dp[N][K]);
	}

}
