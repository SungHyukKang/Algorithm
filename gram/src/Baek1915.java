import java.io.*;
import java.util.*;

public class Baek1915 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String X = br.readLine();
			for (int j = 1; j <= m; j++) {
				arr[i][j] = X.charAt(j - 1) - '0';
			}
		}
		int max = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr[i][j] == 1) {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + arr[i][j];
					max = Math.max(max, dp[i][j]);
					print(dp);
				}
			}
		}
		System.out.println(max * max);

	}

	public static void print(int[][] map) {

		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------");
	}

}
