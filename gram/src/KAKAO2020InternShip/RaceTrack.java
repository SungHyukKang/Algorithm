package KAKAO2020InternShip;
import java.util.*;

class PairRT implements Comparable<PairRT> {
	int x,y,d;
	int lr = 0;
	int ud = 0;
	PairRT(int x, int y,int d,int ud ,int lr){
		this.x=x;
		this.y=y;
		this.d=d;
		this.lr=lr;
		this.ud=ud;
	}
	@Override
	public int compareTo(PairRT arg0) {
		return this.d<=arg0.d ? -1 : 1;
	}
}
public class RaceTrack {
	static int[][] D;
	static int N;
	static int M;
	static int[][] arr;
	static final int INF=1000000;
	static int[] nx= {-1,0,1,0};
	static int[] ny= {0,-1,0,1};
	public static int solution(int[][] board) {
		int answer = 0;
		N = board.length;
		M= board[0].length;
		arr = new int[N][M];
		D=new int[N][M];
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				D[i][j]=INF;
			}
		}
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				arr[i][j]=board[i][j];
			}
		}
		answer=dijkstra();
		System.out.println(answer);
        return answer;
    }
	
	static PriorityQueue<PairRT> pq = new PriorityQueue<>();
	public static int dijkstra() {
		int ans=0;
		D[0][0]=0;
		if(isPossible(0,1)) {
			pq.offer(new PairRT(0,1,100,0,1));
			D[0][1]=100;
			while(!pq.isEmpty()) {
				PairRT n = pq.poll();
				int x = n.x;
				int y = n.y;
				int d = n.d;
				int lr = n.lr;
				int ud = n.ud;
				if(d>D[x][y])
					continue;
				for(int i =0;i<nx.length;i++) {
					int mx = x+nx[i];
					int my = y+ny[i];
					if(isPossible(mx,my)) {
						if(my>y||my<y) {
							if(lr==1) {
								if(D[mx][my]>D[x][y]+100) {
									D[mx][my]=D[x][y]+100;
									pq.offer(new PairRT(mx,my,D[mx][my],0,1));
									continue;
								}
							}else {
								if(D[mx][my]>D[x][y]+600) {
									D[mx][my]=D[x][y]+600;
									pq.offer(new PairRT(mx,my,D[mx][my],0,1));
									continue;
								}
							}
						}
						if(mx>x||mx<x) {
							if(ud==1) {
								if(D[mx][my]>D[x][y]+100) {
									D[mx][my]=D[x][y]+100;
									pq.offer(new PairRT(mx,my,D[mx][my],1,0));
									continue;
								}
							}else {
								if(D[mx][my]>D[x][y]+600) {
									D[mx][my]=D[x][y]+600;
									pq.offer(new PairRT(mx,my,D[mx][my],1,0));
									continue;
								}
							}
						}
					}
				}
			}
			print();
		}
		ans=D[N-1][N-1];
		if(isPossible(1,0)) {
			for(int i =0;i<N;i++) {
				for(int j =0;j<M;j++) {
					D[i][j]=INF;
				}
			}
			D[0][0]=0;
			pq.offer(new PairRT(1,0,100,1,0));
			D[1][0]=100;
			while(!pq.isEmpty()) {
				PairRT n = pq.poll();
				int x = n.x;
				int y = n.y;
				int d = n.d;
				int lr = n.lr;
				int ud = n.ud;
				if(d>D[x][y])
					continue;
				for(int i =0;i<nx.length;i++) {
					int mx = x+nx[i];
					int my = y+ny[i];
					if(isPossible(mx,my)) {
						if(my>y||my<y) {
							if(lr==1) {
								if(D[mx][my]>D[x][y]+100) {
									D[mx][my]=D[x][y]+100;
									pq.offer(new PairRT(mx,my,D[mx][my],0,1));
									continue;
								}
							}else {
								if(D[mx][my]>D[x][y]+600) {
									D[mx][my]=D[x][y]+600;
									pq.offer(new PairRT(mx,my,D[mx][my],0,1));
									continue;
								}
							}
						}
						if(mx>x||mx<x) {
							if(ud==1) {
								if(D[mx][my]>D[x][y]+100) {
									D[mx][my]=D[x][y]+100;
									pq.offer(new PairRT(mx,my,D[mx][my],1,0));
									continue;
								}
							}else {
								if(D[mx][my]>D[x][y]+600) {
									D[mx][my]=D[x][y]+600;
									pq.offer(new PairRT(mx,my,D[mx][my],1,0));
									continue;
								}
							}
						}
					}
				}
			}
		}
		print();
		return Math.min(ans, D[N-1][N-1]);
	}
	
	public static void print() {
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				if(arr[i][j]==1)
					System.out.print("00000 ");
				else if(D[i][j]==INF)
					System.out.print("-INF- ");
				else
					System.out.print("0"+D[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------------------------------------");
	}
	
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M)
			return false;
		if(x==0&&y==0)
			return false;
		if(arr[x][y]==1)
			return false;
		return true;
	}
	
	
	public static void main(String[] args) {
//		solution(new int[][] {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}});
//		solution(new int[][] {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}});
		solution(new int[][] {{0, 0, 1, 0, 1, 1, 0, 0, 0, 0},
		{0, 0, 0, 0, 1, 0, 1, 1, 0, 1},
		{1, 0, 0, 0, 0, 1, 1, 0, 1, 0},
		{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
		{0, 0, 0, 0, 1, 0, 1, 0, 1, 1},
		{0, 0, 1, 0, 1, 1, 0, 1, 0, 1},
		{0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
		{1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
		{1, 0, 0, 0, 0, 0, 0, 0, 1, 0}});
//		solution(new int[][] {
//	        {0, 0, 0, 0, 0},
//	        {0, 1, 1, 1, 0},
//	        {0, 0, 1, 0, 0},
//	        {1, 0, 0, 0, 1},
//	        {0, 1, 1, 0, 0}
//	    });
	}

}
