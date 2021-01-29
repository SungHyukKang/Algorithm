package jvvv;

import java.util.Scanner;

public class Baek9663 {
	public static int N;
	public static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i =0;i<N;i++){
			int[] arr = new int[N];
			arr[0]=i;
			dfs(arr,0);
		}
		System.out.println(count);
	}
	public static void dfs(int[] arr , int row){
		if(row==N-1){
			count++;
			}else{
			for(int i =0;i<N;i++){
				arr[row+1]=i;
				if(isPossible(arr,row+1)){
					dfs(arr,row+1);
				}
			}
			}
	}
	
	public static boolean isPossible(int[] arr , int row){
		for(int i =0;i<row;i++){
			if(arr[i]==arr[row]){
				return false;
			}
			if(Math.abs(i-row) == Math.abs(arr[i]-arr[row]))
				return false;
		}
		return true;
	}
}
