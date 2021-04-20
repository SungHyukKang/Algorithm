import java.io.*;
import java.util.*;

public class Baek14238 {
	static char[] arr;
	static char[] ans;
	static int[] alpha = new int[3];
	static boolean[][][][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine().toCharArray();
		ans = new char[arr.length];
		for (char z : arr) {
			if (z == 'A') {
				alpha[0]++;
			} else if (z == 'B') {
				alpha[1]++;
			} else {
				alpha[2]++;
			}
		}
		dp = new boolean[alpha[0] + 1][alpha[1] + 1][alpha[2] + 1][5][5];
		StringBuilder sb = new StringBuilder();
		if (dfs(0, 0, 0, 4, 4)) {
			for (char z : ans) {
				sb.append(z);
			}
			System.out.println(sb.toString());
		} else
			System.out.println("-1");
	}

	public static boolean dfs(int a, int b, int c, int pre, int ppre) {
		if (a == alpha[0] && b == alpha[1] && c == alpha[2]) {
			return true;
		}
		if (dp[a][b][c][pre][ppre])
			return false;
		dp[a][b][c][pre][ppre] = true;
		if (a + 1 <= alpha[0]) {
			ans[a + b + c] = 'A';
			if (dfs(a + 1, b, c, 0, pre))
				return true;
		}
		if (b + 1 <= alpha[1]) {
			ans[a + b + c] = 'B';
			if (pre != 1) {
				if (dfs(a, b + 1, c, 1, pre))
					return true;
			}
		}
		if (c + 1 <= alpha[2]) {
			ans[a + b + c] = 'C';
			if (pre != 2 && ppre != 2) {
				if (dfs(a, b, c + 1, 2, pre))
					return true;
			}
		}
		return false;
	}

}
