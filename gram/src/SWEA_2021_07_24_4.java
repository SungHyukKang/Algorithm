import java.util.*;
import java.io.*;

public class SWEA_2021_07_24_4 {
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] arr = st.nextToken().toCharArray();
			char[] arr2 = st.nextToken().toCharArray();
			int[][] dp = new int[arr.length + 1][arr2.length + 1];
			int max = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr2.length; j++) {
					if (arr[i] == arr2[j]) {
						dp[i + 1][j + 1] = dp[i][j] + 1;
					} else {
						dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
					}
					max = Math.max(max, dp[i + 1][j + 1]);
				}
			}
			sb.append("#" + test_case + " " + max + "\n");
		}
		System.out.println(sb);
	}

}
