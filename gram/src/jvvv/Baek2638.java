package jvvv;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//class Pair{
//	int x ,y;
//	Pair(int x ,int y){
//		this.x=x;
//		this.y=y;
//	}
//}

public class Baek2638 {
	public static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	public static int[][] arr;
	public static boolean[][] visited;
	public static boolean[][] visited2;
	public static Queue<Pair> queue = new LinkedList<>();
	public static Queue<Pair> queue2 = new LinkedList<>();
	public static Queue<Pair> queue3 = new LinkedList<>();
	public static int N;
	public static int M;
	public static int cnt=0;
	public static void main(String[] args)throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited2=new boolean[N][M];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			func();
			for(int i = 0;i<N;i++) {
				for(int j =0;j<M;j++) {
					if(arr[i][j]==1&&!visited2[i][j]) {
						queue2.offer(new Pair(i,j));
						bfs();
					}
				}
			}
			if(queue3.isEmpty()) {
				break;
			}
			
			while(!queue3.isEmpty()) {
				Pair pair = queue3.poll();
				arr[pair.x][pair.y]=-1;
			}
			cnt++;
		}
		if(cnt==0) {
			cnt=1;
		}
		System.out.println(cnt);
	}
	
	public static void bfs() {
		while(!queue2.isEmpty()) {
			int cnt =0;
			Pair pair = queue2.poll();
			if(isPossible(pair.x+1,pair.y)&&arr[pair.x+1][pair.y]==-1) {
				cnt++;
			}if(isPossible(pair.x-1,pair.y)&&arr[pair.x-1][pair.y]==-1) {
				cnt++;
			}if(isPossible(pair.x,pair.y+1)&&arr[pair.x][pair.y+1]==-1) {
				cnt++;
			}if(isPossible(pair.x,pair.y-1)&&arr[pair.x][pair.y-1]==-1) {
				cnt++;
			}
			if(cnt>=2) {
//				System.out.println(pair.x+" "+pair.y);
          		visited2[pair.x][pair.y]=true;
				queue3.offer(new Pair(pair.x,pair.y));
				arr[pair.x][pair.y]=2;
			}
		}
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

	
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) {
			return false;
		}
		return true;
	}
}
