import java.io.*;
import java.util.StringTokenizer;
public class Baek1932 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int[][] table = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++) {
				table[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[N+1][N+1];
		dp[1][1]=table[1][1];
		int max=dp[1][1];
		if(N>1) {
		for(int i=2;i<=N;i++) {
			for(int j=1;j<=i;j++) {
				dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-1])+table[i][j];
				if(max<dp[i][j]) {
					max=dp[i][j];
				}
			}
		}
		System.out.println(max);
		}
		else {
			System.out.println(dp[1][1]);
		}
		
	}

}
