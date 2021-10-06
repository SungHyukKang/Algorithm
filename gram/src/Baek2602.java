import java.util.*;
import java.io.*;

public class Baek2602 {
	static int[][][] dp;
	static char[] magicScroll;
	static char[][] bridge;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		magicScroll = br.readLine().toCharArray();
		bridge = new char[2][];
		dp = new int[2][21][101];
		for (int i = 0; i < 2; i++) {
			bridge[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 21; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		System.out.println(dfs(0, 0, 0) + dfs(1, 0, 0));
	}

	public static int dfs(int br, int depth, int leng) {
		if (depth == magicScroll.length) {
			return 1;
		}

		if (dp[br][depth][leng] != -1)
			return dp[br][depth][leng];
		dp[br][depth][leng] = 0;
		for (int i = leng; i < bridge[br].length; i++) {
			if (bridge[br][i] == magicScroll[depth])
				dp[br][depth][leng] += dfs((br + 1) % 2, depth + 1, i + 1);
		}

		return dp[br][depth][leng];
	}

}
