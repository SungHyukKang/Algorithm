import java.util.*;
import java.io.*;
public class Baek14503 {
	public static int N;
	public static int M;
	public static int r;
	public static int c;
	public static int d;
	public static int[][] arr;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		st= new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		for(int i =1;i<=N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j =1;j<=M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
	}

}
