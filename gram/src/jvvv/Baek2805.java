package jvvv;

import java.util.Scanner;

public class Baek2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		long[] dp = new long[91];
		dp[0]=1;
		dp[1]=2;
		for(int i =2;i<dp.length;i++){
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println(dp[X-1]);
	}

}
