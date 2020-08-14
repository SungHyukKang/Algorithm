package jvvv;

import java.util.*;

public class Baek1012 {

	static int[][] arr;
	static boolean[][] visited;
	static int M;
	static int N;
	static int K;
	static int cnt=0;
	static ArrayList<Integer> arr2 =new ArrayList<>();
	static void dfs(int x,int y){
		visited[x][y]=true;
		if(locationPossible(x+1,y)){
			dfs(x+1,y);
		}
		if(locationPossible(x-1,y)){
			dfs(x-1,y);
		}
		if(locationPossible(x,y+1)){
			dfs(x,y+1);
		}
		if(locationPossible(x,y-1)){
			dfs(x,y-1);
		}
	}
	
	static boolean locationPossible(int x , int y){
		if(x<0||x>=N||y<0||y>=M){
			return false;
		}
		if(arr[x][y]==1&&!visited[x][y]){
			return true;
		}else
			return false;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int i =0 ;i<T;i++){
			M=sc.nextInt();
			N=sc.nextInt();
			K = sc.nextInt();
			visited=new boolean[N][M];
			arr=new int[N][M];
			for(int j=0;j<K;j++){
				int num1=sc.nextInt();
				int num2=sc.nextInt();
				arr[num2][num1]=1;
			}
			for(int k = 0;k<N;k++){
				for(int j =0;j<M;j++){
					if(locationPossible(k, j)){
						cnt++;
						dfs(k,j);
					}
				}
			}
			System.out.println(cnt);
			cnt=0;
		}
		
		
	}

}
