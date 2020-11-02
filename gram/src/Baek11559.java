import java.util.*;
import java.io.*;

class Pair11559{
	int x,y;
	public Pair11559(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Baek11559 {
	static int puyo=0;
	static int arr[][]=new int[12][6];
	static ArrayList<Pair11559> list = new ArrayList<>();
	static boolean visited[][] =new boolean[12][6];
	static Queue<Pair11559> q = new LinkedList<>();
	static int[] nx= {0,0,1,-1};
	static int[] ny= {1,-1,0,0};
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i =0;i<12;i++) {
			String Z =br.readLine();
			int j=0;
			for(String X : Z.split("")) {
				if(X.equals("R")) {
					arr[i][j]=1;
					puyo++;
				}else if(X.equals("Y")) {
					arr[i][j]=2;
					puyo++;
				}else if(X.equals("G")) {
					arr[i][j]=3;
					puyo++;
				}else if(X.equals("P")){
					arr[i][j]=4;
					puyo++;
				}else if(X.equals("B")){
					arr[i][j]=5;
					puyo++;
				}else
					arr[i][j]=0;
				j++;
			}
		}
		int ans=0;
		boolean tf=false;
		while(true) {
			visited=new boolean[12][6];
			if(puyo<4) {
				break;
			}
			
		for(int i =0;i<12;i++) {
			for(int j =0;j<6;j++) {
				if(!visited[i][j]&&arr[i][j]!=0) {
					list = new ArrayList<>();
					list.add(new Pair11559(i,j));
					visited[i][j]=true;
					q.offer(new Pair11559(i, j));
					bfs(arr[i][j]);
					if(list.size()>=4) {
						for(Pair11559  p: list) {
							arr[p.x][p.y]=0;
							puyo--;
						}
						tf=true;
					}
				}
			}
		}
		if(!tf)
			break;
		ans++;
		for(int i =10;i>=0;i--) {
			for(int j =0;j<6;j++) {
				if(arr[i][j]!=0&&arr[i+1][j]==0) {
					int num =arr[i][j];
					dfs(i,j,num);
				}
			}
		}
		}
		System.out.println(ans);
	}
	
	public static void dfs(int x, int y,int num) {
		if(isPossible(x+1,y)&&arr[x+1][y]==0) {
			arr[x][y]=0;
			arr[x+1][y]=num;
			dfs(x+1,y,num);
		}
	}
	
	public static void bfs(int num) {
		while(!q.isEmpty()) {
			Pair11559 p = q.poll();
			int x= p.x;
			int y =p.y;
			
			for(int i=0;i<nx.length;i++) {
				int mx =nx[i]+x;
				int my=ny[i]+y;
				if(isPossible(mx,my)&&!visited[mx][my]&&arr[mx][my]==num) {
					q.offer(new Pair11559(mx, my));
					visited[mx][my]=true;
					list.add(new Pair11559(mx,my));
				}
			}
			
			
		}
	}
	
	public static boolean isPossible(int x , int y) {
		if(x<0||x>=12||y<0||y>=6) {
			return false;
		}
		return true;
	}
	
	public static void print() {
		for(int i =0;i<12;i++) {
			for(int j=0;j<6;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------------------------");
			
	}
}
