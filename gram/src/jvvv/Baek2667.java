package jvvv;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2667 {
    public static int[][] arr ;
    public static boolean[][] visited;
    static int N;
    public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    ArrayList<Integer> ll = new ArrayList<>();
    arr = new int[N+1][N+1];
    visited=new boolean[N+1][N+1];
    for(int i = 1;i<=N;i++){
    	int j =1;
    	for(String Z : br.readLine().split("")){
    		arr[i][j]=Integer.parseInt(Z);
    		j++;
    	}
    }
    for(int i = 1;i<=N;i++){
    	for(int j=1;j<=N;j++){
    		if(locationPossible(i,j)){
    			int val = dfs(i,j);
    			ll.add(val);
    		}
    	}
    }
    
    Collections.sort(ll);
    System.out.println(ll.size());
    for(int i : ll){
    	System.out.println(i);
    }
}
    
    public static int dfs(int x,int y){
    	int val=1;
    	visited[x][y]=true;
    	if(locationPossible(x-1, y)){
    		val+=dfs(x-1,y);
    	}
		if(locationPossible(x, y-1)){
			val+=dfs(x,y-1);
		}
		if(locationPossible(x+1, y)){
			val+=dfs(x+1,y);
		}
		if(locationPossible(x, y+1)){
			val+=dfs(x,y+1);
		}
    		return val;
    }
    
    public static boolean locationPossible(int x, int y){
    	if((x<1||x>N)||(y<1||x>N)){
    		return false;
    	}
    	if(visited[x][y]==true||arr[x][y]==0){
    		return false;
    	}else
    		return true;
    }
    
}
