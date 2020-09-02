import java.util.*;
import java.io.*;
class Pairr{
	int h;
	int x;
	int y;
	
	Pairr(int h,int x , int y){
		this.h=h;
		this.x=x;
		this.y=y;
	}
}

public class Baek7569 {
	public static int[][][] arr;
	public static int[][][] dist;
	public static Queue<Pairr> queue = new LinkedList<>();
	public static int M;
	public static int N;
	public static int H;
	static int[] dh = { -1, 0, 1, 0, 0, 0 };
    static int[] dx = { 0, 1, 0, -1, 0, 0 };
    static int[] dy = { 0, 0, 0, 0, -1, 1 };
	public static void main(String[] args)throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M =Integer.parseInt(st.nextToken());
		N =Integer.parseInt(st.nextToken());
		H =Integer.parseInt(st.nextToken());
		arr =new int[H][N][M];
		dist=new int[H][N][M];
		for(int h=0;h<H;h++) {
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0;j<M;j++) {
					arr[h][i][j]=Integer.parseInt(st.nextToken());
					if(arr[h][i][j]==1) {
						queue.offer(new Pairr(h,i,j));
					}
				}
			}
		}
		bfs();
		int max=0;
		for(int h=0;h<H;h++) {
			for(int i=0;i<N;i++) {
				for(int j =0;j<M;j++) {
					if(dist[h][i][j]>max)
						max=dist[h][i][j];
				}
			}
		}
		
		for(int h=0;h<H;h++) {
			for(int i=0;i<N;i++) {
				for(int j =0;j<M;j++) {
					if(dist[h][i][j]==0&&arr[h][i][j]==0)
						max=-1;
				}
			}
		}
		System.out.println(max);
	}
		
	
	public static void print() {
		for(int h=0;h<H;h++) {
			for(int i=0;i<N;i++) {
				for(int j =0;j<M;j++) {
					System.out.print(dist[h][i][j]);
				}
				System.out.println();
			}
		}
		System.out.println("-------------------------------------------");
	}
	public static void bfs() {
		while(!queue.isEmpty()) {
			print();
		Pairr pair =queue.poll();
		int h=pair.h;
		int x=pair.x;
		int y=pair.y;
		for(int i =0;i<dh.length;i++) {
			int nh=h+dh[i];
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nh>=0&&nh<H&&nx>=0&&nx<N&&ny>=0&&ny<M) {
				if(arr[nh][nx][ny]==0&&dist[nh][nx][ny]==0) {
					queue.offer(new Pairr(nh,nx,ny));
					dist[nh][nx][ny]=dist[h][x][y]+1;
				}
			}
		}
		}
	}
	
}
