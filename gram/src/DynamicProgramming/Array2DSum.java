package DynamicProgramming;
import java.util.*;

public class Array2DSum {	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] dp = new int[N+1][M];
		for(int i = 0;i<M;i++){
			dp[0][i]=0;
		}
		int t = 0;
		for(int i =1 ;i<dp.length;i++){
				for(int j =0;j<dp[i].length;j++){
				t=sc.nextInt();
				dp[i][j]=dp[i-1][j]+t;
			}
		}
		int cnt =0;
		int sum = 0;
		int sum2=0;
		int K =sc.nextInt();
		while(cnt<K){
			int i =sc.nextInt();
			int j =sc.nextInt();
			int x = sc.nextInt();
			int y=sc.nextInt();
			sum = 0;
			sum2 =0;
			for(int q=j-1/*i = 1 , j = 1 ,x = 2 y = 3*/;q<y;q++){
				sum+=dp[x][q];
			}
			for(int w=j-1;w<y;w++){
				sum2+=dp[i-1][w];
			}
			cnt++;
			System.out.println(sum-sum2);
		}
		}
}
