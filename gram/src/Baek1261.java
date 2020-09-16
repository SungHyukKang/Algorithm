import java.util.*;
import java.io.*;
public class Baek1261 {
	static int M;
	static int N;
	static int[][] arr;
	static int[][] D;
	static final int INF=2100000000;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		arr =new int[N][M];
		D =new int[N][M];
		for(int i =0;i<N;i++) {
			String Z = br.readLine();
			int j =0;
			for(String X : Z.split("")) {
				arr[i][j]=Integer.parseInt(X);
				D[i][j]=INF;
				j++;
			}
		}
		D[0][0]=0;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0,0));
		int[] nx = {0,1,0,-1};
		int[] ny = {1,0,-1,0};
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int x= pair.x;
			int y= pair.y;
			for(int i = 0;i<nx.length;i++) {
				if(isPossible(x+nx[i],y+ny[i])) {
					if(arr[x+nx[i]][y+ny[i]]==1) {
					if(D[x+nx[i]][y+ny[i]]>D[x][y]+1) {
						D[x+nx[i]][y+ny[i]]=D[x][y]+1;
						q.offer(new Pair(x+nx[i],y+ny[i]));
					}
					}else if(arr[x+nx[i]][y+ny[i]]==0) {
						if(D[x+nx[i]][y+ny[i]]>D[x][y]) {
							D[x+nx[i]][y+ny[i]]=D[x][y];
							q.offer(new Pair(x+nx[i],y+ny[i]));	
						}
					}
				}
			}
		}
		System.out.println(D[N-1][M-1]);
	}
	
	
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) {
			return false;
		}
		return true;
	}
}
