import java.util.*;
import java.io.*;

public class Baek9658 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int[] dp =new int[1001];
		dp[1]=1;//0: 상근  1: 창영 , 선공 패  CY
		dp[2]=0; // 선공 승 SK
		dp[3]=1; // 선공 패
		dp[4]=0; // 선공 승
		for(int i=5;i<=N;i++) {
			if(dp[i-1]==0&&dp[i-3]==0&&dp[i-4]==0)
				dp[i]=1;	
			else
				dp[i]=0;
		}
		System.out.println(dp[N]==0 ? "SK":"CY");
	}

}
