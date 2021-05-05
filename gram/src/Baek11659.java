import java.util.*;
import java.io.*;

public class Baek11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = dp[i - 1] + arr[i];
		}
		for (int x = 0; x < M; x++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(dp[j] - dp[i - 1] + "\n");
		}
		System.out.println(sb);
	}

}
