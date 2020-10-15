import java.util.*;
import java.io.*;
public class Baek1743 {
	static int N;
	static int M;
	static int K;
	static int[][] arr;
	static int[] nx = {0,0,1,-1};
	static int[] ny = {1,-1,0,0};
	static boolean[][] visited;
	static int max =0;
	public static int stoi(String x) {return Integer.parseInt(x);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N =stoi(st.nextToken());
		M =stoi(st.nextToken());
		K =stoi(st.nextToken());
		arr=new int[N+1][M+1];
		visited=new boolean[N+1][M+1];
		
		for(int i =0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			int num = stoi(st.nextToken());
			int num2 = stoi(st.nextToken());
			arr[num][num2]=1;
		}
		int answer =0;
		for(int i =1;i<=N;i++) {
			for(int j =1;j<=M;j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					max=1;
					visited[i][j]=true;
					dfs(i,j);
					answer=Math.max(max,answer);
				}
			}
		}
		System.out.println(answer);
	}
	
	static int dfs(int x, int y) {
		for(int i=0;i<nx.length;i++) {
			int mx = x+nx[i];
			int my = y+ny[i];
			if(isPossible(mx,my)&&!visited[mx][my]&&arr[mx][my]==1) {
				visited[mx][my]=true;
				max++;
				dfs(mx,my);
			}
		}
		return max;
	}
	static boolean isPossible(int x, int y) {
		if(x<1||x>N||y<1||y>M)
			return false;
		return true;
	}
}
