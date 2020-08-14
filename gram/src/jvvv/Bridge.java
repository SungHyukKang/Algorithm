package jvvv;
import java.util.Scanner;

public class Bridge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] dp = new int[31][31];
		for(int i = 0;i<dp.length;i++){
			for(int j=0;j<dp[i].length;j++){
				dp[i][j]=0;
			}
		}
		
		for(int i = 0 ;i<31;i++){
			dp[1][i]=i;
		}
		
		for (int i = 2; i < 31; i++)
	    {
	        for (int k = i; k < 31; k++)
	        {
	            for (int l = k-1; l >= i-1; l--) {
	                dp[i][k] += dp[i - 1][l];
	            }
	        }
	    }
		for(int i = 0 ;i<T;i++){
			System.out.println(dp[sc.nextInt()][sc.nextInt()]);
		}
		
		
	}

}
