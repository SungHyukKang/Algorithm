import java.util.*;

import java.io.*;

class Node17472 implements Comparable<Node17472>{
	int s ;
	int e;
	int d;
	
	Node17472(int s, int e, int d){
		this.s=s;
		this.e=e;
		this.d=d;
	}

	@Override
	public int compareTo(Node17472 o) {
		return this.d<=o.d?-1:1;
	}
	
}

class Pair17472{
	int x;
	int y;
	
	public Pair17472(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class Baek17472 {
	static int pre;
	static int N;
	static int M;
	static int[][] arr;
	static int[] parent;
	static int[] ud= {1,-1};
	static int[] nx= {0,0,1,-1};
	static int[] ny= {1,-1,0,0};
	static boolean[][] visited;
	static int cnt =0;
	static PriorityQueue<Node17472> pq = new PriorityQueue<Node17472>();
	static Queue<Pair17472> q = new LinkedList<Pair17472>();
	static int stoi(String X ) { return Integer.parseInt(X);}
	static int find(int s) {
		if(parent[s]==s)
			return s;
		parent[s]=find(parent[s]);
		return parent[s];
	}
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot!=bRoot) {
			parent[aRoot]=b;
		}else
			return;
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		arr =new int[N][M];
		visited = new boolean[N][M];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int num = stoi(st.nextToken());
				arr[i][j]=num;
			}
		}
		for(int i =0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					q.offer(new Pair17472(i, j));
					visited[i][j]=true;
					cnt++;
					arr[i][j]=cnt;
					bfs();
				}
			}
		}
		parent = new int[cnt+1];
		for(int i =1;i<=cnt;i++) {
			parent[i]=i;
		}
		visited = new boolean[N][M];
		for(int i =0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0&&!visited[i][j]) {
					q.offer(new Pair17472(i, j));
					visited[i][j]=true;
					pre=arr[i][j];
					bridge();
				}
			}
		}
		
		int sum = 0;
		int edge=0;
		visited = new boolean[cnt+1][cnt+1];
		while(!pq.isEmpty()) {
			Node17472 n =pq.poll();
			int s = n.s;
			int e = n.e;
			int d = n.d;
			int a = find(s);
			int b = find(e);
			if(a==b||visited[s][e])
				continue;
			union(s,e);
			visited[s][e]=true;
			if(edge+1!=cnt)
				edge++;
			if(edge!=cnt)
				sum+=d;
		}
		
		if(edge+1!=cnt)
			System.out.println("-1");
		else
			System.out.println(sum);
	}
	
	public static void bridge() {
		Pair17472 pair = q.poll();
		int x= pair.x;
		int y= pair.y;
		int cnt=0;
		for(int i =0;i<ud.length;i++) {
			int zx=x;
			int zy=y;
			if(bgPos(zx+ud[i],zy)&&arr[zx+ud[i]][zy]==0) {
				cnt =0;
				while(bgPos(zx+ud[i], zy)&&arr[zx+ud[i]][zy]==0) {
					zx=zx+ud[i];
					cnt++;
				}
				if(bgPos(zx+ud[i],zy)&&arr[zx+ud[i]][zy]!=0&&arr[zx+ud[i]][zy]!=pre&&cnt!=1) {
					pq.offer(new Node17472(Math.min(arr[x][y],arr[zx+ud[i]][zy]),Math.max(arr[x][y],arr[zx+ud[i]][zy]),cnt));
				}
			}
			zx=x;
			if(bgPos(zx,zy+ud[i])&&arr[zx][zy+ud[i]]==0) {
				cnt=0;
				while(bgPos(zx, zy+ud[i])&&arr[zx][zy+ud[i]]==0) {
					zy=zy+ud[i];
					cnt++;
				}
				if(bgPos(zx,zy+ud[i])&&arr[zx][zy+ud[i]]!=0&&arr[zx][zy+ud[i]]!=pre&&cnt!=1) {
					pq.offer(new Node17472(Math.min(arr[x][y],arr[zx][zy+ud[i]]),Math.max(arr[x][y],arr[zx][zy+ud[i]]),cnt));
				}
			}
		}
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Pair17472 pair = q.poll();
			int x = pair.x;
			int y = pair.y;
			for(int i =0;i<nx.length;i++) {
				int mx=x+nx[i];
				int my=y+ny[i];
				if(isPossible(mx,my)&&arr[mx][my]==1) {
					q.offer(new Pair17472(mx,my));
					visited[mx][my]=true;
					arr[mx][my]=cnt;
				}
			}
		}
	}
	
	public static boolean bgPos(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) {
			return false;
		}
		return true;
	}
	
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) {
			return false;
		}
		if(visited[x][y])
			return false;
		return true;
	}
	
	public static void print() {
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
