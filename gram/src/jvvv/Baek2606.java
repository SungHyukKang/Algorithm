package jvvv;

import java.util.Scanner;
public class Baek2606 {
	
	public static boolean[] visited = new boolean[100];
	public static int[][] arr =new int[100][100];
	public static int N;
	public static int X;
	public static int answer=0;
	public static void gogo(int num){
		for(int i = num;i<N;i++){
			if(arr[num][i]==1&&!visited[i]){
				answer++;
				visited[i]=true;
				gogo(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		X = sc.nextInt();
		for(int i =0;i<X;i++){
			int nu1=sc.nextInt()-1;
			int nu2=sc.nextInt()-1;
			arr[nu1][nu2]=1;
			arr[nu2][nu1]=1;
		}
		visited[0]=true;
		gogo(0);
		System.out.println(answer);
		
	}	
	
}
