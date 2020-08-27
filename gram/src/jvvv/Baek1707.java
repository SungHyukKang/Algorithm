package jvvv;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek1707 {
	public static int V;
	public static int E;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[][] colors;
	public static Queue<Integer> queue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		for(int k = 0;k<K;k++) {
			V = sc.nextInt();
			E = sc.nextInt();
			visited = new boolean[V+1][V+1];
			arr = new int[V+1][V+1];
			for(int i=0;i<E;i++) {
				int num=sc.nextInt();
				int num2=sc.nextInt();
				arr[num][num2]=1;
				arr[num2][num]=1;
			}
			queue=new LinkedList<Integer>();
			bfs();
		}
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			
		}
	}
	
}
