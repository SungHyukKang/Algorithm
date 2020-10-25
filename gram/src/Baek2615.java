import java.util.*;
import java.io.*;
public class Baek2615 {
	static int[][] arr;
	static int[] nx= {0,1,1,-1};
	static int[] ny= {1,0,1,1};
	static boolean[][] visited;
	static int xx;
	static int cnt;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr=new int[20][20];
		for(int i=1;i<20;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<20;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<20;i++) {
			for(int j=1;j<20;j++) {
				if(arr[i][j]!=0) {
					xx=arr[i][j];
					for(int z =0;z<nx.length;z++) {
						cnt=0;
						if(isPossible(i+nx[z],j+ny[z])&&arr[i+nx[z]][j+ny[z]]==xx) {
							dfs(i,j,z);
							if(cnt==4&&arr[i-nx[z]][j-ny[z]]!=xx) {
								System.out.println(xx);
								System.out.println(i+" " +j);
								System.exit(0);
							}
						}
					}
				}
			}
		}
		System.out.println("0");
	}
	static void dfs(int x, int y,int dir) {
		if(isPossible(x+nx[dir],y+ny[dir])&&arr[x+nx[dir]][y+ny[dir]]==xx) {
			cnt++;
			dfs(x+nx[dir],y+ny[dir],dir);
		}
	}
	static boolean isPossible(int x,int y) {
		if(x<1||x>19||y<1||y>19) {
			return false;
		}
		return true;
	}
}
