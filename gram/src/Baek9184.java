import java.util.*;
import java.io.*;

public class Baek9184 {

	static int[][][] dp = new int[21][21][21];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			if (A == -1 && B == -1 && C == -1)
				break;

			for (int i = 0; i < 21; i++)
				for (int j = 0; j < 21; j++)
					Arrays.fill(dp[i][j], -1);
			bw.write("w(" + A + ", " + B + ", " + C + ")" + " = " + dfs(A, B, C));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static int dfs(int A, int B, int C) {
		if (A <= 0 || B <= 0 || C <= 0) {
			return 1;
		}

		if (A > 20 || B > 20 || C > 20) {
			return dfs(20, 20, 20);
		}

		if (dp[A][B][C] != -1)
			return dp[A][B][C];
		dp[A][B][C] = 0;
		if (A < B && C > B) {
			dp[A][B][C] = dfs(A, B, C - 1) + dfs(A, B - 1, C - 1) - dfs(A, B - 1, C);
		} else {
			dp[A][B][C] = dfs(A - 1, B, C) + dfs(A - 1, B - 1, C) + dfs(A - 1, B, C - 1) - dfs(A - 1, B - 1, C - 1);
		}

		return dp[A][B][C];

	}

}
