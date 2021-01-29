import java.util.*;
import java.io.*;
class Bead15644{
	int rx;
	int ry;
	int bx;
	int by;
	int cnt;
	StringBuilder sb=  new StringBuilder();
	Bead15644(int rx ,int ry ,int bx ,int by,int cnt,String dir){
		this.rx=rx;
		this.ry=ry;
		this.bx=bx;
		this.by=by;
		this.cnt=cnt;
		sb.append(dir);
	}
}
class Pair15644{
	int x,y,rc;
	
	Pair15644(int x, int y ,int rc){
		this.x=x;
		this.y=y;
		this.rc=rc;
	}
}
public class Baek15644 {
	static int N;
	static int M;
	static boolean[][][][] visited = new boolean[11][11][11][11];
	static Queue<Bead15644> q= new LinkedList<>();
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
		q.add(new Bead15644(rx , ry , bx ,by,1,""));
		visited[rx][ry][bx][by]=true;
		bfs();
	}
	
	public static Pair15644 move(int x ,int y ,int i){
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
		return new Pair15644(x,y,rc);
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
			Bead15644 b = q.poll();
			int rx = b.rx;
			int ry = b.ry;
			int bx = b.bx;
			int by = b.by;
			int cnt =b.cnt;
			if(cnt>10) {
				System.out.println("-1");
				return;
			}
			for(int i =0;i<nx.length;i++) {
				int nrx=rx;
				int nry=ry;
				int nbx=bx;
				int nby=by;
				
				Pair15644 nr = move(nrx,nry,i);
				Pair15644 nb = move(nbx,nby,i);
				if(arr[nb.x][nb.y].equals("O")) continue;
				if(arr[nr.x][nr.y].equals("O")) {
					System.out.println(cnt);
					System.out.println(b.sb.toString()+direction(i));
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
				//0 R , 1 L , 2 D , 3 U
				if(!visited[nr.x][nr.y][nb.x][nb.y]) {
					visited[nr.x][nr.y][nb.x][nb.y]=true;
					q.offer(new Bead15644(nr.x,nr.y,nb.x,nb.y,cnt+1,b.sb.append(direction(i)).toString()));
				}
			}
		}
		System.out.println("-1");
	}
	
	public static String direction(int x) {
		if(x==0) {
			return "R";
		}else if(x==1)
			return "L";
		else if(x==2)
			return "D";
		else
			return "U";
	}
}
