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
	public static Queue<Pair> queue= new LinkedList<>();
	public static Queue<Pair> queue2= new LinkedList<>();
	public static Queue<Pair> queue3= new LinkedList<>();
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
			}
		}
		
		int lastc=0;
		while(true) {
			
			visited = new boolean[N][M];
			func();
			for(int i = 0;i<N;i++) {
				for(int j =0;j<M;j++) {
					if(arr[i][j]==1) {
						queue2.offer(new Pair(i,j));
					}
				}
			}
			bfs();
			if(queue3.isEmpty())
				break;
			lastc=queue3.size();
			while(!queue3.isEmpty()) {
				Pair pair = queue3.poll();
				arr[pair.x][pair.y]=-1;
			}
			count++;
			for(int i =0;i<arr.length;i++) {
				for(int j =0;j<arr[i].length;j++) {
					if(arr[i][j]==-1)
					System.out.print(arr[i][j] + " ");
					else
						System.out.print(" "+arr[i][j] + " ");
				}
				System.out.println();
			}
		System.out.println("-----------------------------------------------------");
		}		
		
		System.out.println(count);
		System.out.println(lastc);
	}
	public static void bfs() {
		while(!queue2.isEmpty()) {
			Pair pair = queue2.poll();
			visited[pair.x][pair.y]=true;
			if(arr[pair.x+1][pair.y]==-1) {
				arr[pair.x][pair.y]=2;
				queue3.offer(new Pair(pair.x,pair.y));
			}else if(arr[pair.x-1][pair.y]==-1) {
				arr[pair.x][pair.y]=2;
				queue3.offer(new Pair(pair.x,pair.y));
			}else if(arr[pair.x][pair.y+1]==-1) {
				arr[pair.x][pair.y]=2;
				queue3.offer(new Pair(pair.x,pair.y));
			}else if(arr[pair.x][pair.y-1]==-1) {
				arr[pair.x][pair.y]=2;
				queue3.offer(new Pair(pair.x,pair.y));
			}
		}
	}
	
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) {
			return false;
		}
		return true;
	}
	
	public static void func() {
		visited=new boolean[N][M];
		queue.offer(new Pair(0,0));
		visited[0][0]=true;
		arr[0][0]=-1;
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			if(isPossible(pair.x+1,pair.y)&&arr[pair.x+1][pair.y]!=1&&!visited[pair.x+1][pair.y]) {
				visited[pair.x+1][pair.y]=true;
				arr[pair.x+1][pair.y]=-1;
				queue.offer(new Pair(pair.x+1,pair.y));
			}if(isPossible(pair.x-1,pair.y)&&arr[pair.x-1][pair.y]!=1&&!visited[pair.x-1][pair.y]) {
				visited[pair.x-1][pair.y]=true;
				arr[pair.x-1][pair.y]=-1;
				queue.offer(new Pair(pair.x-1,pair.y));
			}if(isPossible(pair.x,pair.y+1)&&arr[pair.x][pair.y+1]!=1&&!visited[pair.x][pair.y+1]) {
				visited[pair.x][pair.y+1]=true;
				arr[pair.x][pair.y+1]=-1;
				queue.offer(new Pair(pair.x,pair.y+1));
			}if(isPossible(pair.x,pair.y-1)&&arr[pair.x][pair.y-1]!=1&&!visited[pair.x][pair.y-1]){
				visited[pair.x][pair.y-1]=true;
				arr[pair.x][pair.y-1]=-1;
				queue.offer(new Pair(pair.x,pair.y-1));
			}
		}
	}
}
