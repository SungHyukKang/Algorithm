package jvvv;
import java.io.IOException;
import java.util.Scanner;

public class Baek1081 {

	public static void main(String[] args)throws IOException {
		Scanner sc = new Scanner(System.in);
		String X = sc.next();
		String Z = sc.next();
		int x = Integer.parseInt(X);
		int z = Integer.parseInt(Z);
		long[] dp = new long[z-x+1];
		
		long sumX=0;
		for(String ll : X.split("")){
			sumX+=Integer.parseInt(ll);
		}
		dp[0]=sumX;
		
		for(int i=1;i<dp.length;i++){
			dp[i]=dp[i-1]+i+dp[0];
		}
		System.out.println(dp[dp.length-1]);
		
	}

}
