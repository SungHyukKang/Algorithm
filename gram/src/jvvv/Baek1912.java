package jvvv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1912 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int[] dp =new int[100001];
		int[] arr =new int[N];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i =0 ;i<N;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}
		dp[0]=arr[0];
		for(int i =1;i<N;i++){
			dp[i]=Math.max(dp[i-1]+arr[i], arr[i]);	
		}
		int max = dp[0];
		for(int i =1;i<N;i++){
			if(max<dp[i]){
				max=dp[i];
			}
		}
		System.out.println(max);
		br.close();
	}
}