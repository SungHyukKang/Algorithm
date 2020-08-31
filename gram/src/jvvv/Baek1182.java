package jvvv;
import java.util.Arrays;
import java.util.Scanner;
public class Baek1182 {
	public static int N;
	public static int S;
	public static int[] arr;
	public static int cnt=0;
	public static void main(String[] args) {
		//백준 1182 , 부분수열의 합 //백트래킹
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr =new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		dfs(0,0);
		if(S==0)
			cnt--;
		System.out.println(cnt);
	}
	public static void dfs(int start , int sum) {
		if(start==N) {
			if(sum==S)
				cnt++;
			return;
		}
		dfs(start+1,sum+arr[start]);
		dfs(start+1,sum);
	}
	
	
}