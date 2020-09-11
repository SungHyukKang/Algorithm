import java.util.*;
import java.io.*;

class Pair{
	int x, y;
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}

class Triple{
	int x ,y ,cnt;
	
	Triple(int x, int y, int cnt){
		this.x=x;
		this.y=y;
		this.cnt=cnt;
	}
}
public class Baek2573 {
	public static int N;
	public static int M;
	public static int[][] arr;
	public static boolean[][] conVisited;
	public static boolean[][] iceVisited;
	public static Queue<Pair> conQ = new LinkedList<>();
	public static Queue<Pair> iceQ = new LinkedList<>();
	public static Queue<Triple> cntQ = new LinkedList<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		iceVisited=new boolean[N][M];
		int year=0;
		while(true) {
			int conIsland=0;
			conVisited= new boolean[N][M];
			for(int i =0;i<N;i++) {
				for(int j =0;j<M;j++) {
					if(arr[i][j]!=0&&!conVisited[i][j]) {
						conQ.offer(new Pair(i,j));
						conVisited[i][j]=true;
						connectedBfs();
						conIsland++;
					}
				}
			}
			for(int i =0;i<N;i++) {
				for(int j =0;j<M;j++) {
					if(arr[i][j]!=0) {
						iceQ.offer(new Pair(i,j));
					}
				}
			}
			if(conIsland>=2) {
				break;
			}
			bfs();
			year++;
			if(cntQ.isEmpty())
				break;
			while(!cntQ.isEmpty()) {
				Triple triple = cntQ.poll();
				arr[triple.x][triple.y]=arr[triple.x][triple.y]-triple.cnt;
				if(arr[triple.x][triple.y]<0) {
					arr[triple.x][triple.y]=0;
				}
			}
		}
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(arr[i][j]!=0) {
					System.out.println(year);
					return;
				}
			}
		}
		
		System.out.println("0");
		
	}
	public static void bfs() {
		while(!iceQ.isEmpty()) {
			Pair pair = iceQ.poll();
			int x = pair.x;
			int y = pair.y;
			int cnt=0;
			if(isPossible(x+1,y)&&arr[x+1][y]==0) {
				cnt++;
			}if(isPossible(x-1,y)&&arr[x-1][y]==0) {
				cnt++;
			}if(isPossible(x,y+1)&&arr[x][y+1]==0) {
				cnt++;
			}if(isPossible(x,y-1)&&arr[x][y-1]==0) {
				cnt++;
			}
			cntQ.offer(new Triple(x,y,cnt));
		}
	}
	
	public static void connectedBfs() {
		while(!conQ.isEmpty()) {
			Pair pair = conQ.poll();
			int x = pair.x;
			int y = pair.y;
			if(isPossible(x+1,y)&&!conVisited[x+1][y]&&arr[x+1][y]!=0) {
				conQ.offer(new Pair(x+1,y));
				conVisited[x+1][y]=true;
			}if(isPossible(x-1,y)&&!conVisited[x-1][y]&&arr[x-1][y]!=0) {
				conQ.offer(new Pair(x-1,y));
				conVisited[x-1][y]=true;
			}if(isPossible(x,y+1)&&!conVisited[x][y+1]&&arr[x][y+1]!=0) {
				conQ.offer(new Pair(x,y+1));
				conVisited[x][y+1]=true;
			}if(isPossible(x,y-1)&&!conVisited[x][y-1]&&arr[x][y-1]!=0) {
				conQ.offer(new Pair(x,y-1));
				conVisited[x][y-1]=true;
			}
		}
	}
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) {
			return false;
		}
		return true;
	}
}
