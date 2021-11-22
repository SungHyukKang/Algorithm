import java.util.*;
import java.io.*;

public class Baek1301 {
	static int N;
	static int[] arr;
	static long[][][][][][][] dp;
	static int total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[6];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
		}
		dp = new long[11][11][11][11][11][6][6];

		for (int i = 0; i <= 10; i++)
			for (int j = 0; j <= 10; j++)
				for (int k = 0; k <= 10; k++)
					for (int x = 0; x <= 10; x++)
						for (int z = 0; z <= 10; z++)
							for (int c = 0; c <= N; c++)
								Arrays.fill(dp[i][j][k][x][z][c], -1);
		System.out.println(dfs(0, 0, 0));
	}

	public static long dfs(int ppre, int pre, int sum) {
		if (sum == total) {
			return 1;
		}

		if (dp[arr[1]][arr[2]][arr[3]][arr[4]][arr[5]][ppre][pre] != -1)
			return dp[arr[1]][arr[2]][arr[3]][arr[4]][arr[5]][ppre][pre];
		int a1 = arr[1];
		int a2 = arr[2];
		int a3 = arr[3];
		int a4 = arr[4];
		int a5 = arr[5];
		dp[a1][a2][a3][a4][a5][ppre][pre] = 0;
		for (int i = 1; i <= N; i++) {
			if (arr[i] > 0 && ppre != i && pre != i) {
				arr[i]--;
				dp[a1][a2][a3][a4][a5][ppre][pre] += dfs(pre, i, sum + 1);
				arr[i]++;
			}
		}
		return dp[a1][a2][a3][a4][a5][ppre][pre];
	}

}
