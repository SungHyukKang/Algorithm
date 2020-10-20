import java.util.*;
import java.io.*;
public class Code_force {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int[] dp =new int[10001];
		int[] l = new int[4];
		l[0]=1;
		l[1]=2;
		l[2]=3;
		l[3]=4;
		dp[0]=1;
		dp[1]=3;
		dp[2]=6;
		dp[3]=10;
		for(int i =4;i<10001;i++) {
			dp[i]=dp[i-1]+l[i%4];
		}
		
		for(int i =0;i<N;i++) {
			int num =Integer.parseInt(br.readLine());
			String Z  =String.valueOf(num);
			int mm = (Integer.parseInt(Character.toString(Z.charAt(0)))-1)*4;
			int length =Z.length();
			int full = mm+length;
			System.out.println(dp[full-1]);
			
		}
	}

}
