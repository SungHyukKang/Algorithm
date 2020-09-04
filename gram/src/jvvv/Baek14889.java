package jvvv;

import java.util.Scanner;
import java.util.Stack;

class Pair99{
	
}

public class Baek14889 {
	public static int N;
	public static boolean[][] visited;
	public static int[][] arr;
	public static Stack<Pair> stack;
	public static void dfs() {
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		arr =new int[N+1][N+1];
		for(int i = 1;i<=N;i++){
			for(int j =1;j<=N;j++){
				arr[i][j]=sc.nextInt();
			}
		}
		dfs();
	}
}
