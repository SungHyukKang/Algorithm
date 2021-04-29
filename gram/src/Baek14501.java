import java.util.*;
import java.io.*;

class Pair14501 {
	int i, t, p;

	public Pair14501(int i, int t, int p) {
		this.i = i;
		this.t = t;
		this.p = p;
	}

}

public class Baek14501 {
	static int N;
	static Pair14501[] pairs;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pairs = new Pair14501[N + 1];
		dp = new int[16];
		pairs[0] = new Pair14501(0, 0, 0);
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			pairs[i] = new Pair14501(i, t, p);
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = pairs[i].p;
			for (int j = 1; j < i; j++) {
				if (i - j >= pairs[j].t) {
					dp[i] = Math.max(dp[i], dp[j] + pairs[i].p);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (i + pairs[i].t <= N + 1) {
				max = Math.max(max, dp[i]);
			}
		}
		System.out.println(max);
	}

}
