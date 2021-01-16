import java.util.*;

public class nqueen {
	static int t;
	static int answer = 0;

	public  int solution(int n) {
		t = n;
		for (int i = 0; i < n; i++) {
			int[]arr = new int[n];
			arr[0] = i;
			dfs(arr,0);
		}
		System.out.println(answer);
		return answer;
	}

	public static void dfs(int[] arr,int row) {
		if (row == t - 1) {
			answer++;
			return;
		}
		for (int i = 0; i < t; i++) {
			arr[row + 1] = i;
			if (isPossible(arr,row + 1))
				dfs(arr,row + 1);
		}
	}

	public static boolean isPossible(int[] arr,int row) {
		for (int i = 0; i < row; i++) {
			if (arr[i] == arr[row])
				return false;
			if (Math.abs(i - row) == Math.abs(arr[i] - arr[row]))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		 new nqueen().solution(7);
	}

}
