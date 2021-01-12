import java.util.*;
import java.io.*;

public class Baek11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] S = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		int max=0;
		for (int i = 1; i <= N; i++) {
			dp[i]=1;
			for(int j =1	;j<i ;j++) {
				if(S[j]<S[i]&&dp[j]>=dp[i]) {
					dp[i]=dp[j]+1;
				}
			}
			if(max<dp[i])
				max=dp[i];
		}
		System.out.println(max);
	}

}
