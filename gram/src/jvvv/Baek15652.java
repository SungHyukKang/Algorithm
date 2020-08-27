package jvvv;

import java.util.Scanner;
import java.util.Stack;

public class Baek15652 {
	public static int N;
	public static int M;
	public static Stack<Integer> arr;
	public static boolean[] visited;
	public static void dfs(int start) {
		if(arr.size()==M) {
			for(int i =0;i<arr.size();i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
			return;
		}
		for(int i =1;i<=N;i++) {
			if(!visited[i]&&arr.lastElement()<i) {
				visited[i]=true;
				arr.push(i);
				dfs(i);
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
		for(int i =1;i<=N;i++) {
			arr = new Stack<>();
			visited=new boolean[N+1];
			arr.push(i);
			visited[i]=true;
			dfs(i);
		}
	}
}
