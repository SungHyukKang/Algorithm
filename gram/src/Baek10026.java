import java.util.*;

import java.io.*;

class Pair10026{
	int x,y;
	
	Pair10026(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}

public class Baek10026 {
	public static String[][] arr;
	public static String[][] map;
	public static boolean[][] visited;
	public static boolean[][] visited2;
	static String pre;
	public static int[] nx = {0,1,0,-1};
	public static int[] ny = {1,0,-1,0};
	static Queue<Pair10026> q = new LinkedList<>();
	static Queue<Pair10026> q2 = new LinkedList<>();
	static int N;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		arr =new String[N][N];
		map = new String[N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		for(int i =0;i<N;i++) {
			String[] X = br.readLine().split("");
			int j =0;
			for(String Z : X) {
				arr[i][j]=Z;
				if(Z.equals("G"))
					map[i][j]="R";
				else
					map[i][j]=Z;
				j++;
			}
		}
		
		pre="";
		int cnt =0;
		int cnt2 =0;
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				if(!visited[i][j]) {
					pre=arr[i][j];
					visited[i][j]=true;
					q.offer(new Pair10026(i,j));
					bfs();
					cnt++;
				}
				if(!visited2[i][j]) {
					pre=map[i][j];
					visited2[i][j]=true;
					q.offer(new Pair10026(i,j));
					bfs2();
					cnt2++;
				}
			}
		}
		System.out.println(cnt+" "+cnt2);
	}
	
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=N)
			return false;
		if(visited[x][y]||!arr[x][y].equals(pre))
			return false;
		return true;
	}
	public static boolean isPossible2(int x, int y) {
		if(x<0||x>=N||y<0||y>=N)
			return false;
		if(visited2[x][y]||!map[x][y].equals(pre))
			return false;
		return true;
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			Pair10026 p = q.poll();
			int x= p.x;
			int y =p.y;
			for(int i =0;i<nx.length;i++) {
				int mx=x+nx[i];
				int my=y+ny[i];
				if(isPossible(mx,my)) {
					visited[mx][my]=true;
					q.offer(new Pair10026(mx,my));
				}
			}
		}
	}
	public static void bfs2() {
		while(!q.isEmpty()) {
			Pair10026 p = q.poll();
			int x= p.x;
			int y =p.y;
			for(int i =0;i<nx.length;i++) {
				int mx=x+nx[i];
				int my=y+ny[i];
				if(isPossible2(mx,my)) {
					visited2[mx][my]=true;
					q.offer(new Pair10026(mx,my));
				}
			}
		}
	}

}
