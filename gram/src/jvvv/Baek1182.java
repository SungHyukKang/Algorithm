package jvvv;

import java.util.Scanner;
import java.util.Stack;

public class Baek1182 {

	public static int N;
	public static int S;
	public static int[] arr;
	public static boolean[] visited;
	public static int count=0;
	public static Stack<Integer> stack=new Stack<>();
	public static int sum = 0;
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
		visited = new boolean[N];
		dfs();
		System.out.println(count);
	}
	
	public static void dfs() {
		
	}

}
