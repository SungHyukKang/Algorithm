import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9252 {
	public static int size;
	static char[] o1;
	static char[] o2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		o1 = br.readLine().toCharArray();
		o2 = br.readLine().toCharArray();
		if(o1.length>o2.length) {
			char[] temp = o1;
			o1=o2;
			o2=temp;
		}
		int[][] dp = new int[o1.length + 1][o2.length + 1];
		StringBuilder sb= new StringBuilder();
		for (int i = 1; i <= o1.length; i++) {
			for (int j = 1; j <= o2.length; j++) {
				if (o1[i - 1] == o2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int i = o1.length;
		int j =o2.length;
		while(i>=1&&j>=1) {
			if(dp[i][j]==dp[i-1][j]) {
				i--;
			}else if(dp[i][j]==dp[i][j-1]) {
				j--;
			}else if(dp[i][j]==dp[i-1][j-1]+1){
				sb.append(o1[i	-1]);
				i--;
				j--;
			}
		}
		
		System.out.println(dp[dp.length - 1][dp[0].length - 1]);
		System.out.println(sb.reverse());
	}
	public static void dfs(int idx,int cnt , String str) {
		if(cnt==size) {
			
		}
		
		
		
	}
}
