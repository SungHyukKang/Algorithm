import java.util.*;
import java.io.*;

public class Badk2073 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int[] L = new int[P + 1];
		int[] C = new int[P + 1];
		for (int i = 1; i <= P; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			L[i] = l;
			C[i] = c;
		}
		int[] dp = new int[D + 1];
		dp[0] = Integer.MAX_VALUE;
		for (int i = 1; i <= P; i++) {
			for (int j = D; j >= 0; j--) {
				int k = j + L[i];
				if (k > D)
					continue;
				dp[k] = Math.max(Math.min(dp[j], C[i]), dp[k]);
			}
		}
		System.out.println(dp[D]);
	}

}