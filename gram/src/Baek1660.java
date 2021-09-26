import java.io.*;

public class Baek1660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int nujuk = 0;
		int index = 1;
		int sum = 0;
		int[] arr = new int[200];
		int[] dp = new int[300001];
		while (true) {
			nujuk += index;
			sum += nujuk;
			if (sum >= N) {
				if (sum == N)
					arr[index - 1] = sum;
				break;
			}
			arr[index - 1] = sum;
			index++;
		}
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			int k = Integer.MAX_VALUE;
			for (int j = 0; arr[j] <= i && arr[j] != 0; j++) {
				int t = i - arr[j];
				if (dp[t] < k)
					k = dp[t];
			}
			dp[i] = k + 1;
		}
		System.out.println(dp[N]);
	}

}
