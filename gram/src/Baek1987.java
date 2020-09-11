import java.util.*;
import java.io.*;
public class Baek1987 {
	public static String[][] arr;
	public static int[][] dist;
	public static boolean[][] visited;
	public static int R;
	public static int[] nx= {0,1,0,-1};
	public static int[] ny= {1,0,-1,0};
	
	public static int C;
	public static HashMap<String,Boolean> hsmap = new HashMap<>();
	public static int max = -1;
	public static int cnt=1;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[R][C];
		arr=new String[R][C];
		dist = new int[R][C];
		for(int i = 0;i<R;i++) {
			String Z = br.readLine();
			int j =0;
			for(String X : Z.split("")) {
				arr[i][j]=X;
				hsmap.put(X,false);
				j++;
			}
		}
		visited[0][0]=true;
		hsmap.put(arr[0][0],true);
		
		dfs(0,0);
		System.out.println(max);
	}
	public static void dfs(int x, int y) {
		System.out.println(x+" "+y);
		if(isPossible(x,y)) {
			if(max<cnt) {
				System.out.println("cnt : "+cnt);
				max=cnt;
			}
			System.out.println("--------------------------------");
			return;
		}
		for(int i =0;i<4;i++) {
			if(x+nx[i]>=0&&x+nx[i]<R&&y+ny[i]>=0&&y+ny[i]<C&&!hsmap.get(arr[x+nx[i]][y+ny[i]])&&!visited[x+nx[i]][y+ny[i]]) {
				visited[x+nx[i]][y+ny[i]]=true;
				hsmap.put(arr[x+nx[i]][y+ny[i]],true);
				cnt++;
				dfs(x+nx[i],y+ny[i]);
				cnt--;
				visited[x+nx[i]][y+ny[i]]=false;
				hsmap.put(arr[x+nx[i]][y+ny[i]],false);
			}
		}
	}
	
	public static boolean isPossible(int x, int y) {
		for(int i =0;i<4;i++) {
			if(x+nx[i]>=0&&x+nx[i]<R&&y+ny[i]>=0&&y+ny[i]<C&&!hsmap.get(arr[x+nx[i]][y+ny[i]])&&!visited[x+nx[i]][y+ny[i]]) {
				return false;
			}
		}
		return true;
	}
	
}