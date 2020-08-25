package jvvv;

import java.util.Scanner;
import java.util.Stack;

public class Baek15649 {
//백준 N과 M (1)  , 백트래킹
	public static int N;
	public static int M;
	public static Stack<Integer> arr;
	public static boolean[] visited;
	public static void dfs() {
		if(arr.size()==M) {
			for(int i =0;i<arr.size();i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
			return;
		}
		for(int i =1;i<=N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr.push(i);
				dfs();
				arr.pop();
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		if(M==1) {
			for(int i =1;i<=N;i++) {
				System.out.println(i);
			}
			return;
		}
		arr = new Stack<>();
		visited=new boolean[N+1];
		dfs();
	}
}
