import java.util.*;
import java.io.*;

public class SWEA_2021_07_25_5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] wei = new int[N + 1];
			int[] val = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				wei[i] = Integer.parseInt(st.nextToken());
				val[i] = Integer.parseInt(st.nextToken());
			}
			int[][] dp = new int[N + 1][K + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= K; j++) {
					dp[i][j] = dp[i - 1][j];
					if (j >= wei[i]) {
//						if (dp[i - 1][j] < dp[i - 1][j - wei[i]] + val[i]) {
//							System.out.println(i + " " + wei[i] + " " + val[i] + " " + (j - wei[i]));
//						}
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wei[i]] + val[i]);
					}
					System.out.print(dp[i][j] + " ");
				}
				System.out.println();
			}

			sb.append("#" + test_case + " " + dp[N][K] + "\n");
		}
		System.out.println(sb);
	}

}
