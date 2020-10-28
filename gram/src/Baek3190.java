import java.util.*;
import java.io.*;

class Pair3190{
	int x,y,dir;
	
	Pair3190(int x, int y,int dir){
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
}

public class Baek3190 {
	static int N;
	static int K;
	static int arr[][];
	static boolean visited[][];
	static int[] nx= {0,0,1,-1};
	static int[] ny= {1,-1,0,0};
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine());
		arr=new int[N+1][N+1];
		visited=new boolean[N+1][N+1];
		LinkedList<Pair3190> ll = new LinkedList<>();
		
		for(int i =0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
		}
		int C= Integer.parseInt(br.readLine());
		ll.offer(new Pair3190(1,1,0));
		visited[1][1]=true;
		int ans=0;
		for(int i =0;i<C;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-ans;
			for(int j =0;j<x;j++) {
				ans++;
				Pair3190 p =ll.peekFirst();
				int mx =p.x+nx[p.dir];
				int my =p.y+ny[p.dir];
				if(isPossible(mx,my)&&!visited[mx][my]) {
					if(arr[mx][my]==1) {
						arr[mx][my]=0;
						visited[mx][my]=true;
						ll.addFirst(new Pair3190(mx,my,p.dir));
					}else {
							Pair3190 pp =ll.pollLast();
							visited[pp.x][pp.y]=false;
							ll.addFirst(new Pair3190(mx,my,p.dir));
							visited[mx][my]=true;
					}
				}else {
					System.out.println(ans);
					System.exit(0);
				}
			}
			
			String dir = st.nextToken();
			ll.peek().dir= dir.equals("L") ? turnL(ll.peek().dir):turnR(ll.peek().dir);
		}
		while(true) {
			ans++;
			Pair3190 p =ll.peekFirst();
			int mx =p.x+nx[p.dir];
			int my =p.y+ny[p.dir];
			if(isPossible(mx,my)&&!visited[mx][my]) {
				if(arr[mx][my]==1) {
					arr[mx][my]=0;
					visited[mx][my]=true;
					ll.addFirst(new Pair3190(mx,my,p.dir));
				}else {
						Pair3190 pp =ll.pollLast();
						visited[pp.x][pp.y]=false;
						ll.addFirst(new Pair3190(mx,my,p.dir));
						visited[mx][my]=true;
				}
			}else {
				System.out.println(ans);
				System.exit(0);
			}
		}
	}
//	static int[] nx= {0,0,1,-1};
//	static int[] ny= {1,-1,0,0};
	
	static int turnL(int dir) {
		if(dir==0) {
			return 3;
		}else if(dir==1) {
			return 2;
		}else if(dir==2) {
			return 0;
		}else
			return 1;
	}
	static int turnR(int dir) {
		if(dir ==0) {
			return 2;
		}else if(dir==1) {
			return 3;
		}else if(dir==2) {
			return 1;
		}else
			return 0;
	}
	
	public static boolean isPossible(int x, int y) {
		if(x<1||x>N||y<1||y>N) {
			return false;
		}
		return true;
	}
}
