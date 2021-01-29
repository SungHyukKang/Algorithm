import java.util.*;
import java.io.*;


class PairE{
	int x,y;
	PairE(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class Baek20005 {
	static int M;
	static int N;
	static int P;
	static int[][] arr;
	static PairE boss;
	static int[][] D;
	static int[] nx= {0,0,1,-1};
	static int[] ny= {1,-1,0,0};
	static HashMap<Character,Integer> hsmapD = new HashMap<>();
	static final int INF=2100000000;
	static ArrayList<PairE> list =new ArrayList<>(); 
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = stoi(st.nextToken());
		N = stoi(st.nextToken());
		D=new int[M][N];
		P = stoi(st.nextToken());
		HashMap<Character,Integer> hsmap = new HashMap<>();
		arr =new int[M][N];
		for(int i =0;i<M;i++) {
			String X =br.readLine();
			for(int j =0;j<N;j++) {
				D[i][j]=INF;
				if(X.charAt(j)=='.') {
					arr[i][j]=0;
				}else if(X.charAt(j)=='X') {
					arr[i][j]=-1;
				}else if(X.charAt(j)=='B') {
					boss = new PairE(i,j);
				}else{
					list.add(new PairE(i,j));
					arr[i][j]=-(X.charAt(j));
				}
			}
		}
		for(int i =0;i<P;i++) {
			st=new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			int xx = stoi(st.nextToken());
			hsmap.put(a,xx);
		}
		dijkstra();
		int HP = stoi(br.readLine());
		int cnt =0;
		while(true) {
			if(HP<=0)
				break;
			for(char hero : hsmapD.keySet()) {
				hsmapD.put(hero,hsmapD.get(hero)-1);
				if(hsmapD.get(hero)==0)
					cnt++;
				if(hsmapD.get(hero)<=0) {
					HP-=hsmap.get(hero);
				}
			}
		}
		System.out.println(cnt);
	}
	
	
	public static void dijkstra() {
		for(int i =0;i<list.size();i++) {
			PairE paire =list.get(i);
			Queue<PairE> q = new LinkedList<PairE>();
			q.offer(new PairE(paire.x,paire.y));
			resetD();
			D[paire.x][paire.y]=0;
			while(!q.isEmpty()) {
				PairE p = q.poll();
				int x =p.x;
				int y= p.y;
				if(x==boss.x&&y==boss.y) {
					break;
				}
				for(int j=0;j<nx.length;j++) {
					int mx = x+nx[j];
					int my = y+ny[j];
					if(isPossible(mx,my)) {
						if(D[mx][my]>D[x][y]+1) {
							D[mx][my]=D[x][y]+1;
							q.offer(new PairE(mx,my));
						}
					}
				}
			}
			if(D[boss.x][boss.y]!=INF)
			hsmapD.put((char)-arr[paire.x][paire.y],D[boss.x][boss.y]);
		}
	}
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=M||y<0||y>=N) {
			return false;
		}
		if(arr[x][y]!=0&&arr[x][y]==-1)
			return false;
		return true;
	}
	public static void resetD() {
		for(int i =0;i<M;i++) {
			for(int j =0;j<N;j++) {
				D[i][j]=INF;
			}
		}
	}
	public static void print() {
		for(int i =0;i<M;i++) {
			for(int j =0;j<N;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
