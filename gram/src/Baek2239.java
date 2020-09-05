import java.io.*;

public class Baek2239 {
	public static boolean[][] rowC= new boolean[9][10] ;
	public static boolean[][] colC= new boolean[9][10] ;
	public static boolean[][] squC= new boolean[9][10] ;
	public static int[][] arr =new int [9][9];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i =0;i<9;i++) {
			int j =0;
			String Z = br.readLine();
			for(String C : Z.split(" ")) {
				arr[i][j]=Integer.parseInt(C);
				if(arr[i][j]!=0) {
					rowC[i][arr[i][j]] = true;
					colC[j][arr[i][j]] = true;
					squC[(i/3)*3+j/3][arr[i][j]]=true;
				}
				j++;
			}
		}
		dfs(0);	
	}
	public static void dfs(int cnt) {
		int x = cnt/9;
		int y = cnt%9;
		if(cnt == 81) {
			print();
			System.exit(0);
		}
		if(arr[x][y]==0) {
				for(int i =1;i<=9;i++) {
					if(!rowC[x][i] &&!colC[y][i]&&!squC[(x/3)*3+y/3][i]) {
						rowC[x][i]=true;
						colC[y][i]=true;
						squC[(x/3)*3+y/3][i]=true;
						arr[x][y]=i;
						dfs(cnt+1);
						arr[x][y]=0;
						rowC[x][i]=false;
						colC[y][i]=false;
						squC[(x/3)*3+y/3][i]=false;
					}
				}
		}else 
			dfs(cnt+1);
	}
	
	
	public static void print() {
		for(int i =0;i<9;i++) {
			for(int j =0;j<9;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
