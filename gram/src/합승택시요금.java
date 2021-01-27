import java.util.*;

public class 합승택시요금 {

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 0;
		int[][] arr = new int[n + 1][n + 1];
		int INF = 21000000;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i != j)
					arr[i][j] = INF;
			}
		}

		for (int i = 0; i < fares.length; i++) {
			arr[fares[i][0]][fares[i][1]] = fares[i][2];
			arr[fares[i][1]][fares[i][0]] = fares[i][2];
		}
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(arr[i][j]>arr[i][k]+arr[k][j]) {
						arr[i][j]=arr[i][k]+arr[k][j];
					}
				}
			}
		}
		int min =INF;
		for(int i =1;i<=n;i++) {
			min =Math.min(min, arr[s][i]+arr[i][a]+arr[i][b]);
		}
		answer=min;
		return answer;
	}

	public static void main(String[] args) {
		solution(6, 4, 6, 2, new int[][] { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 },
				{ 4, 6, 50 }, { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } });
	}

}
