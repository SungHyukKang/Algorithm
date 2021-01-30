import java.io.*;
public class Baek9251 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] o1 = br.readLine().toCharArray();
		char[] o2=br.readLine().toCharArray();
		int[][] dp = new int[o1.length+1][o2.length+1];
		for(int i =1;i<=o1.length;i++) {
			for(int j = 1;j<=o2.length;j++) {
				if(o1[i-1]==o2[j-1]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[dp.length-1][dp[0].length-1]);
		
	}
}
