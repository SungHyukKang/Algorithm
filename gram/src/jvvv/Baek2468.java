package jvvv;

import java.util.*;
//class Pair{
//int x,y;
//
//Pair(int x, int y){
//  this.x=x;
//  this.y=y;
//}
//}
public class Baek2468 {
	public static int[][] arr;
	public static boolean[][] visited;
	public static int N;
	public static Queue<Pair> queue = new LinkedList<>();
	public static int maximum;
	public static int minimum;
	public static int cnt=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr=new int[N][N];
		int maxcnt=0;
		int max = 0;
		int min = 100001;
		for(int i = 0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]>max) {
					max=arr[i][j];
				}
				if(arr[i][j]<min) {
					min=arr[i][j];
				}
			}
		}
		for(int m =0; m<=max;m++) {
			maximum=m;
			queue = new LinkedList<>();
			cnt=0;
			visited=new boolean[N][N];
		for(int i =0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]>maximum&&!visited[i][j]) {
					queue.offer(new Pair(i,j));
					visited[i][j]=true;
					bfs();
					cnt++;
				}
			}
		}
		
		if(maxcnt<cnt) {
			maxcnt=cnt;
		}
		}
		if(maxcnt==0) {
			maxcnt=1;
		}
		System.out.println(maxcnt);
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			if(isPossible(pair.x+1,pair.y)&&arr[pair.x+1][pair.y]>maximum) {
				queue.offer(new Pair(pair.x+1,pair.y));
				visited[pair.x+1][pair.y]=true;
			}if(isPossible(pair.x-1,pair.y)&&arr[pair.x-1][pair.y]>maximum) {
				queue.offer(new Pair(pair.x-1,pair.y));
				visited[pair.x-1][pair.y]=true;
			}if(isPossible(pair.x,pair.y+1)&&arr[pair.x][pair.y+1]>maximum) {
				queue.offer(new Pair(pair.x,pair.y+1));
				visited[pair.x][pair.y+1]=true;
			}if(isPossible(pair.x,pair.y-1)&&!visited[pair.x][pair.y-1]&&arr[pair.x][pair.y-1]>maximum) {
				queue.offer(new Pair(pair.x,pair.y-1));
				visited[pair.x][pair.y-1]=true;
			}
		}
	}
	
	public static boolean isPossible(int x , int y) {
		if(x<0||x>=N||y<0||y>=N) {
			return false;
		}
		if(visited[x][y]) {
			return false;
		}
		
		return true;
	}
}
