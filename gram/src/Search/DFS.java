package Search;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class DFS {
	@SuppressWarnings("resource")
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int cnt =0;
	public static boolean[] visit = new boolean[10001];
	public static boolean[] visitB = new boolean[10001];
	public static void dfs(int start,boolean[] visit,int[][] arr){
		if(cnt==M){
			return;
		}else{
			System.out.println(start);
		for(int i =0;i<10000;i++){
			if(arr[start-1][i]==1&&!visit[i]){
				visit[i]=true;
				arr[i][start-1]=0;
				dfs(i+1,visit,arr);
				cnt++;
				break;
			}
		}
		}
	}
	
	public static void bfs(int start ,boolean[] visitB,int[][] arrB){
		if(cnt ==M)
			return;
		else{
			System.out.println(start);
			for(int i =0;i<10000;i++){
				if(arrB[start-1][i]==1&&!visitB[i]){
					visitB[i]=true;
					arrB[i][start-1]=0;
					bfs(start-1,visitB,arrB);
					cnt++;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		int V =sc.nextInt();
		visit[V-1]=true;
		visitB[V-1]=true;
		int[][] arr =new int[1000][10000];
		int[][] arrB = new int[1000][10000];
		for(int i = 0;i<M;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x-1][y-1]=1;
			arr[y-1][x-1]=1;
			arrB[x-1][y-1]=1;
			arrB[y-1][x-1]=1;
			
		}
		dfs(V,visit,arr);
		cnt=0;
		bfs(V,visitB,arrB);
		
	}
}