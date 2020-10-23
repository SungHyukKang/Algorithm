import java.util.*;
import java.io.*;

class Bead13459{
	int rx;
	int ry;
	int bx;
	int by;
	int cnt;
	Bead13459(int rx ,int ry ,int bx ,int by,int cnt){
		this.rx=rx;
		this.ry=ry;
		this.bx=bx;
		this.by=by;
		this.cnt=cnt;
	}
}
class Pair13459{
	int x,y,rc;
	
	Pair13459(int x, int y ,int rc){
		this.x=x;
		this.y=y;
		this.rc=rc;
	}
}
public class Baek13459 {
	static int N;
	static int M;
	static boolean[][][][] visited = new boolean[11][11][11][11];
	static Queue<Bead13459> q= new LinkedList<>();
	static String[][] arr = new String[11][11];
	static int[] nx = {0,0,1,-1};
	static int[] ny = {1,-1,0,0};
	static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		int rx =0;
		int bx =0;
		int ry =0;
		int by =0;
		
		for(int i =0;i<N;i++) {
			String X = br.readLine();
			int j=0;
			for(String Z : X.split("")) {
				arr[i][j]=Z;
				if(Z.equals("B")) {
					bx=i;
					by=j;
				}else if(Z.equals("R")){
					rx=i;
					ry=j;
				}
				j++;
			}
		}
		q.add(new Bead13459(rx , ry , bx ,by,0));
		visited[rx][ry][bx][by]=true;
		bfs();
	}
	
	public static Pair13459 move(int x ,int y ,int i){
		int rc=0;
		while(true) {
			x+=nx[i];
			y+=ny[i];
			if(arr[x][y].equals("#")) {
				x-=nx[i];
				y-=ny[i];
				break;
			}
			if(arr[x][y].equals("O")) {
				break;
			}
			rc++;
		}
		return new Pair13459(x,y,rc);
	}
	public static void print() {
		for(int i =0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			Bead13459 b = q.poll();
			int rx = b.rx;
			int ry = b.ry;
			int bx = b.bx;
			int by = b.by;
			int cnt =b.cnt;
			if(cnt>=10) {
				System.out.println("0");
				return;
			}
			for(int i =0;i<nx.length;i++) {
				int nrx=rx;
				int nry=ry;
				int nbx=bx;
				int nby=by;
				
				Pair13459 nr = move(nrx,nry,i);
				Pair13459 nb = move(nbx,nby,i);
				if(arr[nb.x][nb.y].equals("O")) continue;
				if(arr[nr.x][nr.y].equals("O")) {
					System.out.println("1");
					return;
				}
				
				if(nb.x==nr.x&&nb.y==nr.y) {
					if(nb.rc>nr.rc) {
						nb.x-=nx[i];
						nb.y-=ny[i];
					}else {
						nr.x-=nx[i];
						nr.y-=ny[i];
					}
				}
				
				if(!visited[nr.x][nr.y][nb.x][nb.y]) {
					visited[nr.x][nr.y][nb.x][nb.y]=true;
					q.offer(new Bead13459(nr.x,nr.y,nb.x,nb.y,cnt+1));
				}
			}
		}
		System.out.println("0");
	}
}
