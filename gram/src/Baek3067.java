import java.util.*;
import java.io.*;

public class Baek3067 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(br.readLine());
			int[] dp = new int[money + 1];
			dp[0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = arr[i]; j < money + 1; j++) {
					dp[j] += dp[j - arr[i]];
				}
			}
			sb.append(dp[money]).append("\n");
		}
		System.out.println(sb);
	}

}
