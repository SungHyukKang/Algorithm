import java.util.*;
import java.io.*;


public class Baek2146 {
	static int startP;
	static int N;
	static int[][] arr;
	public static int[] nx = {0,1,0,-1};
	static boolean[][] visited ;
	static boolean[][] visited2 ;
	static int min=2100000000;
	public static int[] ny = {1,0,-1,0};
	static Queue<Pair> q = new LinkedList<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N][N];
		arr= new int[N][N];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		q = new LinkedList<>();
		int cnt =0;
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					q.offer(new Pair(i,j));
					visited[i][j]=true;
					cnt++;
					arr[i][j]=-cnt;
					while(!q.isEmpty()) {
						Pair pair = q.poll();
						int x= pair.x;
						int y= pair.y;
						for(int z =0;z<nx.length;z++) {
							if(isPossible(x+nx[z],y+ny[z])&&arr[x+nx[z]][y+ny[z]]!=0) {
								arr[x+nx[z]][y+ny[z]]=-cnt;
								visited[x+nx[z]][y+ny[z]]=true;
								q.offer(new Pair(x+nx[z],y+ny[z]));
							}
						}
						
					}
				}
			}
		}
		print(arr);
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		q=new LinkedList<>();
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				if(arr[i][j]!=0&&!visited2[i][j]) {
					System.out.println("START ! ! ! x : "+i +" y : "+j);
					q=new LinkedList<>();
					startP=arr[i][j];
					visited= new boolean[N][N];
					q.offer(new Pair(i,j));
					visited[i][j]=true;
					bfs();
					System.out.println("--------------------------");
				}
			}
		}
		print(arr);
		System.out.println(min-1);
	}
	public static void bfs() {
		System.out.println("!!!!!!!!!!!BFS!!!!!!!!!!!!!!!!!!!");
		int cnt =0;
		int[][] arr2 = new int[N][N];
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int x= pair.x;
			int y= pair.y;
			System.out.println(x + " " + y);
			if(arr[x][y]!=0&&arr[x][y]!=startP) {
				if(min>arr2[x][y]) {
					min=arr2[x][y];
					System.out.println("min min min : "+min);
				}
				break;
			}
			for(int i =0;i<nx.length;i++) {
				if(isPossible(x+nx[i],y+ny[i])&&(arr[x+nx[i]][y+ny[i]]==0||arr[x+nx[i]][y+ny[i]]!=startP)&&!visited[x+nx[i]][y+ny[i]]) {
					arr2[x+nx[i]][y+ny[i]]=arr2[x][y]+1;
					q.offer(new Pair(x+nx[i],y+ny[i]));
					visited[x+nx[i]][y+ny[i]]=true;
				}
			}
		}
		print(arr2);
	}
	
	public static boolean isPossible2(int x, int y) {
		if(x<0||x>=N||y<0||y>=N) {
			return false;
		}
		if(visited2[x][y]) {
			return false;
		}
		return true;
	}
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=N) {
			return false;
		}
		if(visited[x][y]) {
			return false;
		}
		return true;
	}
	public static void print(int[][] arr) {
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}
}
