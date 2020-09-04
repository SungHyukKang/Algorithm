import java.util.*;
import java.io.*;

public class Baek2206 {
	public static int[][] arr;
	public static int N;
	public static int M;
	public static boolean[][] visited;
	public static boolean[][] visited2;
	public static Queue<Pair> queue = new LinkedList<>();
	public static Queue<Pair> queue2 = new LinkedList<>();
	public static int cnt=1;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr =new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		visited2	 = new boolean[N+1][M+1];
		
		for(int i =1;i<=N;i++) {
			String Z = br.readLine();
			int j =1;
			for(String X : Z.split("")) {
				arr[i][j++]=Integer.parseInt(X);
			}
		}
		queue.offer(new Pair(1,1));
		visited[1][1]=true;
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			int x = pair.x;
			int y = pair.y;
			if(x==N&&y==M) {
				break;
			}
			if(isPossible(x+1,y)) {
				if(arr[x+1][y]!=1) {
					queue.offer(new Pair(x+1,y));
					visited[x+1][y]=true;
					arr[x+1][y]=arr[x][y]+1;
				}else {
					queue2.offer(new Pair(x+1,y));
					arr[x+1][y]=arr[x][y]+1;
					visited2[x+1][y]=true;
				}
			}if(isPossible(x-1,y)) {
				if(arr[x-1][y]!=1) {
					queue.offer(new Pair(x-1,y));
					visited[x-1][y]=true;
					arr[x-1][y]=arr[x][y]+1;
				}else {
					queue2.offer(new Pair(x-1,y));
					arr[x-1][y]=arr[x][y]+1;
					visited2[x-1][y]=true;
				}
			}if(isPossible(x,y+1)) {
				if(arr[x][y+1]!=1) {
					queue.offer(new Pair(x,y+1));
					visited[x][y+1]=true;
					arr[x][y+1]=arr[x][y]+1;
				}else {
					queue2.offer(new Pair(x,y+1));
					visited2[x][y+1]=true;
					arr[x][y+1]=arr[x][y]+1;
				}
			}if(isPossible(x,y-1)) {
				if(arr[x][y-1]!=1) {
					queue.offer(new Pair(x,y-1));
					visited[x][y-1]=true;
					arr[x][y-1]=arr[x][y]+1;
				}else {
					queue2.offer(new Pair(x,y-1));
					visited2[x][y-1]=true;
					arr[x][y-1]=arr[x][y]+1;
				}
			}
			
			if(queue.isEmpty()&&cnt==1) {
				cnt--;
				if(isPossible(x+1,y)) {
					visited[x+1][y]=true;
					arr[x+1][y]=arr[x][y]+1;
					queue.offer(new Pair(x+1,y));
				}if(isPossible(x-1,y)) {
					visited[x+1][y]=true;
					arr[x-1][y]=arr[x][y]+1;
					queue.offer(new Pair(x-1,y));
				}if(isPossible(x,y+1)) {
					visited[x][y+1]=true;
					arr[x][y+1]=arr[x][y]+1;
					queue.offer(new Pair(x,y+1));
				}if(isPossible(x,y-1)) {
					visited[x][y-1]=true;
					arr[x][y-1]=arr[x][y]+1;
					queue.offer(new Pair(x,y-1));
				}
			}
			
		}
		print();
		if(cnt==1) {
			while(!queue2.isEmpty()) {
				Pair pair = queue2.poll();
				int x =pair.x;
				int y=  pair.y;
				if(x==N&&y==M) {
					break;
				}
				System.out.println("!");
				if(isPossible(x+1,y)&&arr[x+1][y]!=1) {
					queue2.offer(new Pair(x+1,y));
					arr[x+1][y]=arr[x][y]+1;
					visited[x+1][y]=true;
				}if(isPossible(x-1,y)&&arr[x-1][y]!=1) {
					queue2.offer(new Pair(x-1,y));
					arr[x-1][y]=arr[x][y]+1;
					visited[x-1][y]=true;
				}if(isPossible(x,y+1)&&arr[x][y+1]!=1) {
					queue2.offer(new Pair(x,y+1));
					arr[x][y+1]=arr[x][y]+1;
					visited[x][y+1]=true;
				}if(isPossible(x,y-1)&&arr[x][y-1]!=1) {
					queue2.offer(new Pair(x,y-1));
					arr[x][y-1]=arr[x][y]+1;
					visited[x][y-1]=true;
				}
				
				print();
			}
		}
		if(arr[N][M]==0)
			System.out.println("-1");
		else
			System.out.println(arr[N][M]+1);
		
		
	}
	
	public static boolean isPossible(int x, int y) {
		if(x<1||x>N||y<1||y>M) {
			return false;
		}
		if(visited[x][y])
			return false;
		return true;
	}
	public static void print() {
		for(int i =1;i<=N;i++) {
			for(int j =1;j<=M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
}


