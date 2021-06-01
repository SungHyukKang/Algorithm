
public class 거스름돈 {

	public static int solution(int[] money, int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 0; i < money.length; i++) {
			for (int j = money[i]; j <= n; j++) {
				dp[j] = dp[j] + dp[j - money[i]];
			}
		}
		System.out.println(dp[n]);
		return dp[n];
	}

	public static void main(String[] args) {
		solution(new int[] { 1, 2, 5 }, 5);
	}

}
