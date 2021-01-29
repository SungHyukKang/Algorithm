import java.util.*;
import java.io.*;

class Pair16236{
	int x,y,level,eat,time;
	
	Pair16236(int x, int y,int level,int e,int t){
		this.x=x;
		this.y=y;
		this.level=level;
		this.eat=e;
		this.time=t;
	}
	
}

public class Baek16236 {
	static int N;
	static int[][] arr;
	static int eat=0;
	static int[][] map;
	static boolean[][] visited;
	static int[] nx= {0,-1,1,0};
	static int[] ny= {-1,0,0,1};
	static ArrayList<Pair16236> list = new ArrayList<Pair16236>();
	static Queue<Pair16236> q = new LinkedList<>();
	static HashMap<Integer,Integer> hsmap =new HashMap<>();
	public static int stoi(String x) {return Integer.parseInt(x);}
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		arr = new int[N][N];
		map=new int[N][N];
		visited=new boolean[N][N];
		for(int i =0;i<N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				arr[i][j]=stoi(st.nextToken());
				if(arr[i][j]==9) {
					visited[i][j]=true;
					arr[i][j]=0;
					q.offer(new Pair16236(i,j,2,0,0));
				}
				if(arr[i][j]>=1&&arr[i][j]<=6) {
					hsmap.put(arr[i][j],hsmap.getOrDefault(arr[i][j], 0)+1);
				}
			}
		}
		System.out.println(hsmap);
		bfs();
	}
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=N)
			return false;
		return true;
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Pair16236 p = q.poll();
			int x =p.x;
			int y= p.y;
			int l= p.level;
			int e= p.eat;
			int t= p.time;
			boolean tf=false;
			for(int i =1;i<l;i++) {
				if(hsmap.get(i)!=null&&hsmap.get(i)!=0) {
					tf=true;
					break;
				}
			}
			if(!tf) {
				System.out.println(t);
				break;
			}
			for(int i =0;i<nx.length;i++) {
				int mx = x+nx[i];
				int my = y+ny[i];
				if(isPossible(mx,my)&&arr[mx][my]<=l&&!visited[mx][my]) {
					if(arr[mx][my]!=0&&arr[mx][my]<l) {
						int temp=l;
						int tempe=e;
						tempe++;
						if(temp==tempe) {
							temp++;
							tempe=0;
						}
						list.add(new Pair16236(mx,my,temp,tempe,t+1));
					}else {
						q.offer(new Pair16236(mx,my,l,e,t+1));
						visited[mx][my]=true;
					}
				}
			}
			if(list.isEmpty())continue;
			Collections.sort(list , new Comparator<Pair16236>() {
				@Override
				public int compare(Pair16236 arg0, Pair16236 arg1) {
					System.out.println(arg0.x+ " "+arg1.x);
					if(arg0.x==arg1.x) {
						if(arg0.y>arg1.y) {
							return 1;
						}else
							return -1;
					}else if(arg0.x>arg1.x) {
						return 1;
					}else
						return 0;
				}
			});
			Pair16236 go = list.get(0);
			q=new LinkedList<>();
			q.offer(go);
			int mx =q.peek().x;
			int my =q.peek().y;
			visited = new boolean[N][N];
			System.out.println(mx+" " +my);
			visited[mx][my]=true;
			hsmap.put(arr[mx][my],hsmap.get(arr[mx][my])-1);
			arr[mx][my]=0;
			list=new ArrayList<>();
		}
	}
	
	static void print() {
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				if(map[i][j]<10) {
					System.out.print(map[i][j]+"  ");
				}else
					System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}
	
}
