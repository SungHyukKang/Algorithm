import java.io.*;

class SWEA_2021_07_19_03 {
	static final int mod = 1000000007;

	public static int solution(String str) {
		int[][] dp = new int[str.length()][16];
		for (int i = 0; i < str.length(); i++) {
			int king = 1 << str.charAt(i) - 'A';// i일 차의 책임자
			for (int j = 1; j <= 15; j++) { // i일차에 가능한 모든 경우의 수를 구한다.
				if (i == 0) {
					if ((j & 1) != 0 && (j & king) != 0) { // 0일차에는 무조건 A가 있어야 하므로 0일차의 책임자와 A를 동시에 가지고 있는 모든 경우의 수를
															// 구한다.
						dp[i][j] = 1;
					}
				} else {
					if (dp[i - 1][j] != 0) {// 전날에 있었던 부원들이 i번째 날에도 나온다.
						for (int k = 1; k <= 15; k++) {
							if ((j & k) != 0 && (king & k) != 0) {
								dp[i][k] = dp[i][k] + dp[i - 1][j];
								dp[i][k] %= mod;
							}
						}
					}
				}
			}
		}
		int answer = 0;
		for (int i = 1; i <= 15; i++) {
			answer += dp[str.length() - 1][i];
			answer %= mod;
		}
		return answer;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			sb.append("#" + test_case + " " + solution(str) + "\n");
		}
		System.out.println(sb);
	}
}