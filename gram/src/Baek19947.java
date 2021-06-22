import java.util.*;
import java.io.*;

public class Baek19947 {

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int H = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[] dp = new int[Y + 1];
		dp[0] = H;
		for (int i = 1; i <= Y; i++) {
			dp[i] = (int) (dp[i - 1] * 1.05);
			if (i >= 3) {
				dp[i] = (int) Math.max((dp[i - 3] * 1.2), dp[i]);
			}

			if (i >= 5) {
				dp[i] = (int) Math.max((dp[i - 5] * 1.35), dp[i]);
			}
		}
		System.out.println(dp[Y]);
	}
}
