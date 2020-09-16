import java.util.*;
import java.io.*;
class Pair0{
	int x;
	int y;
	int cnt;
	int dist;
	
	Pair0(int x, int y,int cnt,int dist){
		this.x=x;
		this.y=y;
		this.cnt=cnt;
		this.dist=dist;
	}
}
public class Baek2206 {
	public static int[][] arr;
	public static int N;
	public static int M;
	public static Queue<Pair0> queue = new LinkedList<>();
	public static int[][] D;
	static boolean[][] visited;
	public static final int INF=2100000000;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr =new int[N][M];
		visited = new boolean[N][M];
		D = new int[N][M];
		int ans=-1;
		for(int i =0;i<N;i++) {
			String Z = br.readLine();
			int j =0;
			for(String X : Z.split("")) {
				arr[i][j]=Integer.parseInt(X);
				D[i][j]=INF;
				j++;
			}
		}
		queue.offer(new Pair0(0,0,0,1));
		D[0][0]=0;
		int[] nx = {0,0,1,-1};
		int[] ny = {1,-1,0,0};
		while(!queue.isEmpty()) {
			Pair0 pair = queue.poll();
			int x= pair.x;
			int y= pair.y;
			int cnt =pair.cnt;
			int dist = pair.dist;
			if(x==N-1&&y==M-1){
				ans=dist;
				break;
			}
			for(int i =0;i<nx.length;i++) {
				if(isPossible(x+nx[i],y+ny[i])) {
					if(D[x+nx[i]][y+ny[i]]<=cnt) {
						continue;
					}
					if(arr[x+nx[i]][y+ny[i]]==1) {
							if(cnt==0) {
								queue.offer(new Pair0(x+nx[i],y+ny[i],cnt+1,dist+1));
								D[x+nx[i]][y+ny[i]]=cnt+1;
						}
					}else if(arr[x+nx[i]][y+ny[i]]==0) {
							queue.offer(new Pair0(x+nx[i],y+ny[i],cnt,dist+1));
							D[x+nx[i]][y+ny[i]]=cnt;
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void print() {
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(arr[i][j]==INF) {
					System.out.print("INF ");
				}else
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) {
			return false;
		}
		return true;
	}
}


