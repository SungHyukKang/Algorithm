import java.util.*;
import java.io.*;

public class Baek18353 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int here = 0;
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					here = Math.max(here, dp[j]);
				}
			}
			dp[i] = here + 1;
			answer = Math.max(dp[i], answer);
		}
		System.out.println(N - answer);

	}

}
