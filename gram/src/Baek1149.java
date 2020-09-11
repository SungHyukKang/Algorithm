import java.util.*;
import java.io.*;
public class Baek1149 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] dp = new int[N][3];
		for(int i = 0;i<N;i++) {
		int j = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if(i==0)
				dp[0][j]=num;
			arr[i][j]=num;
			j++;
			}
		}
		for(int i =1;i<N;i++) {
			dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+arr[i][0];
			dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+arr[i][1];
			dp[i][2]=Math.min(dp[i-1][1],dp[i-1][0])+arr[i][2];
		}
		int min = 2100000000;
		for(int i = 0 ;i<3;i++) {
			if(min>dp[N-1][i]) {
				min=dp[N-1][i];
			}
		}
		System.out.println(min);
		
		
	}
	
}
