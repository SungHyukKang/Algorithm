import java.io.*;

public class Baek2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][3];
		int[] S = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			S[i] = Integer.parseInt(br.readLine());
		}
		if(N==1) {
			System.out.println(S[1]);
			return;
		}
		dp[1][1] = S[1];
		dp[1][2] = 0;
		dp[2][1] = S[2];
		dp[2][2] = S[2] + S[1];
		if(N>=3)
		for (int i = 3; i <= N; i++) {
			dp[i][1] = Math.max(dp[i-2][1],dp[i-2][2])+S[i];
			dp[i][2]=dp[i-1][1]+S[i];
		}
		bw.write(Math.max(dp[N][1],dp[N][2])+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
