package DynamicProgramming;

import java.util.*;

public class Landing {
	int solution(int[][] land){
		int[][] dp =new int[land.length][4];
		dp[0][0]=land[0][0];
		dp[0][1]=land[0][1];
		dp[0][2]=land[0][2];
		dp[0][3]=land[0][3];
		for(int i = 0;i<land.length-1;i++){
			dp[i+1][0]=MAX(dp[i][1],dp[i][2],dp[i][3])+land[i+1][0];
			dp[i+1][1]=MAX(dp[i][0],dp[i][2],dp[i][3])+land[i+1][1];
			dp[i+1][2]=MAX(dp[i][1],dp[i][0],dp[i][3])+land[i+1][2];
			dp[i+1][3]=MAX(dp[i][1],dp[i][2],dp[i][0])+land[i+1][3];
		}
		return MAX2(dp[dp.length-1][0],dp[dp.length-1][1],dp[dp.length-1][2],dp[dp.length-1][3]);
	}
	
	static int MAX(int i , int j , int k){
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(i);
		arr.add(j);
		arr.add(k);
		Collections.sort(arr);	
		return arr.get(arr.size()-1);
	}
	static int MAX2(int i ,int j ,int k , int x){
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(i);
		arr.add(j);
		arr.add(k);
		arr.add(x);
		Collections.sort(arr);		
		return arr.get(arr.size()-1);
	}
	public static void main(String[] args) {
		Landing land = new Landing();
		land.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}});
	}

}
