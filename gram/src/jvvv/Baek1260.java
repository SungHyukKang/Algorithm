package jvvv;

import java.util.*;

public class Baek1260 {
	
	public static boolean[] visited = new boolean[1001];
	
	static int N ;
	static int M ;
	static int countD =0;
	static int countB=0;
	public static void dfs(int start,int[][] arr){
		System.out.print(start+" ");
		countD++;
		for(int i =1;i<=N;i++){
			if(countD==N){
				return;
			}
			if(arr[start][i]==1&&!visited[i]){
				visited[i]=true;
				dfs(i,arr);
			}
		}
	}
	
	public static void bfs(int start,int[][] arr){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start]=true;
		while(!queue.isEmpty()){
			int x = queue.poll();
			System.out.print(x+" ");
			for(int i=1;i<=N;i++){
				if(arr[x][i]==1&&!visited[i]){
					visited[i]=true;
					queue.offer(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		int[][] arr =new int[1001][1001];
		int start =sc.nextInt();
		for(int i =1  ;i<=M;i++){
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			arr[num1][num2]=1;
			arr[num2][num1]=1;
		}
		visited[start]=true;
		dfs(start,arr);
		System.out.println();
		visited=new boolean[1001];
		bfs(start,arr);
	}

}
