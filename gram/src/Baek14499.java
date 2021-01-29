import java.util.*;
import java.io.*;
public class Baek14499 {
	static int[][] arr;
	static int N;
	static int M;
	static int[] nx= {0,0,0,-1,1} ;
	static int[] ny = {0,1,-1,0,0};
	
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		int r = stoi(st.nextToken());
		int c = stoi(st.nextToken());
		int K =stoi(st.nextToken());
		HashMap<Integer,Integer> hsmap = new HashMap<>();
		for(int i =1;i<=6;i++) {
			hsmap.put(i,0);
		}
		
		arr=new int[N][M];
		for(int i =0;i<N;i++) {
			st=new StringTokenizer(st.nextToken());
			for(int j=0;j<M;j++) {
				arr[i][j]=stoi(st.nextToken());
			}
		}
	}
	static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) {
			return false;
		}
		return true;
	}
}
