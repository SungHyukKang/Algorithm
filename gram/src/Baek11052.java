import java.util.*;
import java.io.*;

public class Baek11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] S = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			for(int j =1;j<=i;j++) {
				dp[i]=Math.max(dp[i],dp[i-j]+S[j]);
			}
		}
		System.out.println(dp[N]);

	}

}
