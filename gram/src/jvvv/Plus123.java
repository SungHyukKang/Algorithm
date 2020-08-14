package jvvv;

import java.util.Scanner;

public class Plus123 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[12];
		int[] answer = new int[12];
		dp[0]=1;
		dp[1]=2;
		dp[2]=3;
		answer[0]=1;
		for(int i = 3;i<11;i++){
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
		for(int i =0;i<dp.length;i++){
			System.out.println(dp[i]);
		}
		for(int i = 1;i<11;i++){
			answer[i]=answer[i-1]+dp[i-1];
		}
		
		for(int i = 0;i<N;i++){
			System.out.println(answer[sc.nextInt()-1]);
		}
		
	}
}
