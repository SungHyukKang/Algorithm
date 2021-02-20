import java.util.*;
import java.io.*;

public class Baek11722 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = 0;
		int[] arr = new int[N];
		int[] dp = new int[N];
		while (st.hasMoreTokens()) {
			int x = Integer.parseInt(st.nextToken());
			arr[c++] = x;
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j <= i; j++) {
				if (arr[j] > arr[i] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
				max = Math.max(dp[i], max);
			}
		}
		System.out.println(max);

	}
}
