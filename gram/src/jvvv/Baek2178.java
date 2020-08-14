package jvvv;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair2{
	int x,y;
	
	Pair2(int x,  int y){
		this.x=x;
		this.y=y;
	}
}

public class Baek2178 {
	static int[][] arr ;
	static boolean[][] visited;
	
	static int N;
	static int M;
	static boolean locationProblem(int x , int y){
		if(x<1||x>=N||y<1||y>=M){
			return false;
		}
		if(arr[x][y]==1&&!visited[x][y]){
			return true;
		}else
			return false;
	}
	static void bfs(int x,int y){
		int[] xx={0,1,0,-1};
		int[] yy={1,0,-1,0};
		Queue<Pair2> q = new LinkedList<>();
		q.add(new Pair2(x,y));
		
		while(!q.isEmpty()){
			Pair2 pair = q.poll();
			visited[pair.x][pair.y]=true;
		for(int i =0;i<4;i++){
			if(locationProblem(pair.x+xx[i],pair.y+yy[i])){
				q.add(new Pair2(pair.x+xx[i],pair.y+yy[i]));
				arr[pair.x+xx[i]][pair.y+yy[i]]=arr[pair.x][pair.y]+1;
			}
		}
		}
		System.out.println(arr[N-1][M-1]);
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken())+1;
		M=Integer.parseInt(st.nextToken())+1;
		arr=new int[N][M];
		visited = new boolean[N][M];
		for(int i =1;i<arr.length;i++){
			int j =1;
			for(String X : br.readLine().split("")){
				arr[i][j]=Integer.parseInt(X);
				j++;
			}
		}
		bfs(1,1);
		br.close();
	}

}
