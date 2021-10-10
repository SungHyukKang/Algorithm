import java.util.*;
import java.io.*;

public class Baek1106 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[C + 101];
		Arrays.fill(dp, 987654321);
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken()); // cost
			int customer = Integer.parseInt(st.nextToken()); // customer
			for (int j = customer; j < C + 101; j++) {
				dp[j] = Math.min(dp[j], cost + dp[j - customer]);
			}
		}
		int answer = 987654321;
		for (int i = C; i < C + 101; i++) {
			if (answer > dp[i]) {
				answer = dp[i];
			}
		}
		System.out.println(answer);
	}

}
