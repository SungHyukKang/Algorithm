package jvvv;

import java.util.Scanner;
import java.util.Stack;

public class Baek2644 {
	public static int[][] arr;
	public static boolean[] visited;
	public static int cnt=0;
	public static int N;
	public static int p1;
	public static int p2;
	public static int M;
	public static Stack<Integer> stack = new Stack<>();
	public static boolean tf=true;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		p1= sc.nextInt();
		p2= sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][N+1];
		visited=new boolean[N+1];
		for(int i = 0;i<M;i++) {
			int num= sc.nextInt();
			int num2= sc.nextInt();
			arr[num][num2]=1;
			arr[num2][num]=1;
		}
		visited[p1]=true;
		dfs(p1);
		if(tf)
			System.out.println("-1");
	}
	public static void dfs(int v) {
		if(v==p2) {
			System.out.println(stack.size());
			tf=false;
			return;
		}
		for(int i =1;i<=N;i++) {
			if(!visited[i]&&arr[v][i]==1) {
				visited[i]=true;
				stack.push(i);
				dfs(i);
				stack.pop();
			}
		}
	}
}
