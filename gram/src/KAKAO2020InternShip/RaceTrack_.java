package KAKAO2020InternShip;
import java.util.*;

class PairRT_ implements Comparable<PairRT_> {
	int x,y,d,direction;
	PairRT_(int x, int y,int d,int direction){
		this.x=x;
		this.y=y;
		this.d=d;
		this.direction=direction;
	}
	@Override
	public int compareTo(PairRT_ arg0) {
		return this.d<=arg0.d ? -1 : 1;
	}
}
public class RaceTrack_ {
	static int[][][] D;
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
		D=new int[N][M][4];
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				for(int k=0;k<4;k++)
					D[i][j][k]=INF;
			}
		}
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				arr[i][j]=board[i][j];
			}
		}
		dijkstra();
		answer =INF;
		for(int i =0;i<4;i++) {
			answer=Math.min(answer,D[N-1][N-1][i]);
		}
		
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				if(D[i][j][2]==INF)
					System.out.print("000 ");
				else if(arr[i][j]==1) {
					System.out.print("111 ");
				}else
				System.out.print(D[i][j][2] +" ");
			}
			System.out.println();
		}
		
		
        return answer;
    }
	
	public static void dijkstra() {
		PriorityQueue<PairRT_> pq = new PriorityQueue<>();
		D[0][0][0]=0;
		D[0][0][1]=0;
		D[0][0][2]=0;
		D[0][0][3]=0;
		
		pq.offer(new PairRT_(0,0,0,0));
		pq.offer(new PairRT_(0,0,0,1));
		pq.offer(new PairRT_(0,0,0,2));
		pq.offer(new PairRT_(0,0,0,3));
		
		while(!pq.isEmpty()) {
			PairRT_ p = pq.poll();
			int x= p.x;
			int y= p.y;
			int d= p.d;
			int direction = p.direction;
			
			for(int i =0;i<nx.length;i++) {
				int mx = nx[i]+x;
				int my = ny[i]+y;
				if(Math.abs(direction-i)==2)
					continue;
				
				if(mx<0||my<0||mx>=N||my>=N||arr[mx][my]==1) {
					continue;
				}
				
				int cost = 0;
				if(direction==i)
					cost=100;
				else
					cost=600;
				int cd = cost+d;
				if(D[mx][my][i]>cd) {
					D[mx][my][i]=cd;
					pq.offer(new PairRT_(mx,my,cd,i));
				}
			}
		}
	}
	public static void main(String[] args) {
//		solution(new int[][] {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}});
//		solution(new int[][] {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}});
		solution(new int[][] {
		{0, 0, 1, 0, 1, 1, 0, 0, 0, 0},
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
