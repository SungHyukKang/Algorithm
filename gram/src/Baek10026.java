import java.util.*;
import java.io.*;
public class Baek10026 {
	public static String[][] arr;
	public static boolean[][] visited;
	public static int[] nx = {0,1,0,-1};
	public static int[] ny = {1,0,-1,0};
	static int N;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		arr =new String[N][N];
		visited = new boolean[N][N];
		for(int i =0;i<N;i++) {
			String[] X = br.readLine().split("");
			int j =0;
			for(String Z : X) {
				arr[i][j]=Z;
			}
		}
		for(int i =0;i<N;i++) {
			
		}
		
	}
	public static void dfs(int x , int y) {
		
	}

}
