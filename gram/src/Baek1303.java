import java.io.*;
import java.util.*;

class Pairrr{
	int x,y;
	
	Pairrr(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Baek1303 {
	static int[][] arr;
	static int[][] arr2;
	static boolean[][] visited;
	static int[] nx = {0,1,0,-1};
	static int[] ny= {1,0,-1,0};
	static int N;
	static Queue<Pairrr> q = new LinkedList<>();
	static int M;
	static int X=0;
	static int Y=0;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		arr= new int[M][N];
		arr2 =new int[M][N];
		visited=new boolean[M][N];
		for(int i =0;i<M;i++) {
			String X = br.readLine();
			int j =0;
			for(String Z : X.split("")) {
				if(Z.equals("W")) {
					arr[i][j]=0;
					arr2[i][j]=-1;
				}else {
					arr[i][j]=-1;
					arr2[i][j]=0;
				}
				j++;
			}
		}
		for(int i =0;i<M;i++) {
			for(int j =0;j<N;j++) {
				if(arr[i][j]!=-1&&!visited[i][j]) {
					visited[i][j]=true;
					q.offer(new Pairrr(i,j));
					X+=Math.pow(bfs()+1, 2);
				}
			}
		}
		q=new LinkedList<>();
		for(int i =0;i<M;i++) {
			for(int j =0;j<N;j++) {
				if(arr2[i][j]!=-1&&!visited[i][j]) {
					q.offer(new Pairrr(i,j));
					visited[i][j]=true;
					Y+=Math.pow(bfs2()+1, 2);
					continue;
				}
			}
		}
		System.out.println(X+" "+Y);
	}
	static int bfs() {
		int cnt=0;
		while(!q.isEmpty()) {
			Pairrr pair = q.poll();
			int x = pair.x;
			int y= pair.y;
			for(int i=0;i<nx.length;i++) {
				if(isPossible(x+nx[i],y+ny[i])) {
					cnt++;
					q.offer(new Pairrr(x+nx[i],y+ny[i]));
					visited[x+nx[i]][y+ny[i]]=true;
				}
			}
		}
		return cnt;
	}
	static int bfs2() {
		int cnt=0;
		while(!q.isEmpty()) {
			Pairrr pair = q.poll();
			int x = pair.x;
			int y= pair.y;
			for(int i=0;i<nx.length;i++) {
				if(isPossible2(x+nx[i],y+ny[i])) {
					cnt++;
					q.offer(new Pairrr(x+nx[i],y+ny[i]));
					visited[x+nx[i]][y+ny[i]]=true;
				}
			}
		}
		return cnt;
	}
	static boolean isPossible(int x, int y) {
		if(x<0||x>=M||y<0||y>=N) {
			return false;
		}
		if(visited[x][y]||arr[x][y]==-1) {
			return false;
		}
		return true;
	}
	
	static boolean isPossible2(int x, int y) {
		if(x<0||x>=M||y<0||y>=N) {
			return false;
		}
		if(visited[x][y]||arr2[x][y]==-1) {
			return false;
		}
		return true;
	}
	static void print(int[][] arr ) {
		for(int i =0;i<M;i++) {
			for(int j =0;j<N;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}
}
