import java.util.*;
import java.io.*;
class Pair16234{
	int x,y;
	
	Pair16234(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Baek16234 {
	static int N;
	static int L;
	static int R;
	static boolean tf=false;
	static int[][] arr;
	static boolean[][] visited;
	static boolean[][] visited2;
	static Queue<Pair16234> q =new LinkedList<>();
	static int[] nx= {0,0,1,-1};
	static int[] ny= {1,-1,0,0};
	static ArrayList<Pair16234> list = new ArrayList<>();
	static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		arr=new int[N][N];
		visited=new boolean[N][N];
		L=stoi(st.nextToken());
		R=stoi(st.nextToken());
		for(int i =0;i<N;i++) {
			int j=0;
			st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				arr[i][j]=stoi(st.nextToken());
				j++;
			}
		}
		int ans=0;
		while(true) {
			tf=false;
		visited=new boolean[N][N];
		visited2=new boolean[N][N];
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				if(!visited2[i][j]) {
					list=new ArrayList<>();
					list.add(new Pair16234(i,j));
					bfs(i,j);
				}
			}
		}
		if(!tf)
			break;
		ans++;
		}
		System.out.println(ans);
	}
	
	static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=N) {
			return false;
		}
		return true;
	}
	static void bfs(int c ,int d) {
		int sum=arr[c][d];
		int cnt=1;
		q.offer(new Pair16234(c,d));
		while(!q.isEmpty()) {
			Pair16234 p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int i =0;i<nx.length;i++) {
				int mx=x+nx[i];
				int my=y+ny[i];
				if(isPossible(mx,my)&&!visited[mx][my]&&!visited2[mx][my]) {
					int X = (int)Math.abs(arr[mx][my]-arr[x][y]);
					if(X>=L&&X<=R) {
						visited[x][y]=true;
						visited[mx][my]=true;
						list.add(new Pair16234(mx,my));
						sum+=arr[mx][my];
						cnt++;
						q.offer(new Pair16234(mx,my));
						tf=true;
					}
				}
			}
		}
		for(Pair16234 pp : list) {
			int i=pp.x;
			int j=pp.y;
			visited[i][j]=false;
			visited2[i][j]=true;
			arr[i][j]=sum/cnt;
		}
	}
}
