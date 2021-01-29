import java.io.*;
import java.util.*;
public class Baek15684 {
	static int N;
	static int M;
	static int H;
	static boolean[][] visited;
	static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		H = stoi(st.nextToken());
		visited=new boolean[H+1][N];
		for(int i =0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int num =stoi(st.nextToken());
			int num2 =stoi(st.nextToken());
			visited[num][num2]=true;
		}
	}
	static void dfs(int idx,int cnt) {
		if(cnt>3) {
			return;
		}
		
		
		for(int i =idx;i<=H;i++) {
			for(int j=1;j<N;j++) {
			if(visited[i][j])
				continue;
			if(visited[i][j+1])
				continue;
			if(visited[i][j-1])
				continue;
			visited[i][j]=true;
			dfs(idx,cnt+1);
			visited[i][j]=false;
			}
		}
	}
	static boolean isPossible() {
		
		return true;
	}
}
