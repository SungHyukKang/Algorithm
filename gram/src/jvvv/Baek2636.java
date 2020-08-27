package jvvv;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Baek2636 {
	public static int N;
	public static int M;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int count=0;
	public static Queue<Pair> queue= new LinkedList<>();;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr=new int[N][M];
		visited=new boolean[N][M];
		for(int i =0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int num =sc.nextInt();
				arr[i][j]=num;
				if(arr[i][j]==1) {
					queue.offer(new Pair(i,j));
				}
			}
		}
		bfs();
		
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				System.out.print(arr[i][j]+" ");
				
			}
			System.out.println(); 
			
		}
		
		System.out.println(count);
		
	}
	public static void bfs() {
		
	}
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M){
            return false;
        }
		if(arr[x][y]==1||!visited[x][y]) {
			visited[x][y]=true;
			return true;
		}
		return false;
	}
}
