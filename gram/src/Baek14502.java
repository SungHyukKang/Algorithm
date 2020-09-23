import java.util.*;
import java.io.*;
public class Baek14502 {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] arrCpy;
	static boolean[][] visited;
	static int[] nx = {0,0,1,-1};
	static int[] ny = {1,-1,0,0};
	static int max=0;
	static ArrayList<Pair> list =new ArrayList<>();
	static Queue<Pair> q = new LinkedList<>();
	static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N =stoi(st.nextToken());
		M =stoi(st.nextToken());
		arr=new int[N][M];
		arrCpy=new int[N][M];
		visited=new boolean[N][M];
		for(int i =0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=stoi(st.nextToken());
			}
		}
		for(int i =0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==2) {
					list.add(new Pair(i,j));
				}
			}
		}
		wall(0,0);
		System.out.println(max);
	}
	
	public static void wall(int start ,int cnt) {
		if(cnt==3) {
			for(int i =0;i<N;i++) {
				for(int j =0;j<M;j++) {
					arrCpy[i][j]=Integer.valueOf(arr[i][j]);
				}
			}
			visited = new boolean[N][M];
			bfs();
			int safe=0;
			for(int i =0;i<N;i++) {
				for(int j =0;j<M;j++) {
					if(arrCpy[i][j]==0) {
						safe++;
					}
				}
			}
			if(max<safe){
				max=safe;
			}
			return;
		}
		for(int  i=start ; i<N*M;i++) {
			int x = i/M;
			int y = i%M;
			if(arr[x][y]==0) {
				arr[x][y]=1;
				wall(i+1,cnt+1);
				arr[x][y]=0;
			}
		}
	}
	
	public static void bfs() {
		for(Pair p : list) {
			q.offer(p);
		}
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int x = pair.x;
			int y = pair.y;
			for(int i =0;i<nx.length;i++) {
				int mx = nx[i]+x;
				int my = ny[i]+y;
				if(isPossible(mx,my)&&arrCpy[mx][my]==0) {
					q.offer(new Pair(mx,my));
					arrCpy[mx][my]=2;
					visited[mx][my]=true;
				}
			}
		}
	}
	public static void print() {
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				System.out.print(arrCpy[i][j]);
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}
	
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) {
			return false;
		}
		if(visited[x][y]) {
			return false;
		}
		return true;
	}
}