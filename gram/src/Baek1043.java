import java.util.*;
import java.io.*;
public class Baek1043 {
	static int[][] arr;
	static boolean[] trueman;
	static boolean[][] visited;
	static int M;
	static int N;
	static boolean[] party;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		arr =new int[M+1][N+1];
		trueman = new boolean[N+1];
		visited = new boolean[M+1][N+1];
		party = new boolean[M+1];
		for(int i =1;i<=S;i++) {
			trueman[Integer.parseInt(st.nextToken())]=true;
		}
		for(int i =1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j = 1;j<=num;j++) {
				int pt = Integer.parseInt(st.nextToken());
				arr[i][pt]=1;
			}
		}
		
		for(int i =1;i<=N;i++) {
			if(trueman[i]) {
				dfs(i);
			}
		}
		int cnt =0;
		for(int i =1;i<=M;i++) {
			if(!party[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int tm) {
		for(int i =1;i<=M;i++) {
			if(arr[i][tm]==1) {
				visited[i][tm]=true;
				party[i]=true;
				for(int j =1;j<=N;j++) {
					if(arr[i][j]==1&&!visited[i][j]) {
						visited[i][j]=true;
						dfs(j);
					}
				}
			}
		}
	}
	
	static void print() {
		for(int i =1;i<=M;i++) {
			for(int j =1;j<=N;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
}
