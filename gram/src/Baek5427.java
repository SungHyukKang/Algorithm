import java.util.*;
import java.io.*;
class PPair{
	int x;
	int y;
	
	PPair(int x, int y){
		this.x=x;
		this.y=y;
	}
}


public class Baek5427 {
	public static int[][] fireMap;
	public static int[][] humanMap;
	public static boolean[][] visited;
	public static int w;
	public static int h;
	public static Queue<PPair> fireQueue = new LinkedList<>();
	public static Queue<PPair> humanQueue = new LinkedList<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		fireMap = new int[h][w];
		humanMap = new int[h][w];
		visited = new boolean[h][w];
		
		for(int i =0;i<h;i++) {
			String X = br.readLine();
			int j =0;
			for(String Z:X.split("")) {
				if(Z.equals("#")) {
					fireMap[i][j]=-1;
					humanMap[i][j]=-1;
					j++;
				}else if (Z.equals(".")){
					fireMap[i][j]=0;
					humanMap[i][j]=0;
					j++;
				}else if (Z.equals("*")){
					fireMap[i][j]=1;
					humanMap[i][j]=-1;
					j++;
				}else {
					fireMap[i][j]=0;
					humanMap[i][j]=1;
					j++;
				}
			}
		}
		
		fireQueueSet();
		bfs2();
		visited=new boolean[h][w];
		humanQueueSet();
		bfs();
		int min =0;
		for(int i =0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(humanMap[i][j]==0)
					humanMap[i][j]=-1;
			}
		}
		
		for(int i =0;i<w;i++) {
			if(humanMap[0][i]!=-1) {
			if(min==0) {
				min=humanMap[0][i];
				continue;
			}
			if(min>humanMap[0][i]) {
				min=humanMap[0][i];
			}
			}
		}
		for(int i =0;i<w;i++) {
			if(humanMap[h-1][i]!=-1) {
				if(min==0) {
					min=humanMap[h-1][i];
					continue;
				}
				if(min>humanMap[h-1][i])
					min=humanMap[h-1][i];
			}
		}
		for(int i =0;i<h;i++) {
			if(humanMap[i][0]!=-1) {
				if(min==0) {
					min=humanMap[i][0];
					continue;
				}

				if(min>humanMap[i][0])
					min=humanMap[i][0];
			}
		}
		for(int i =0;i<h;i++) {
			if(humanMap[i][w-1]!=-1) {
				if(min==0) {
					min=humanMap[i][w-1];
					continue;
				}
				if(min>humanMap[i][w-1])
					min=humanMap[i][w-1];
			}
		}
		if(min == 0) {
			System.out.println("IMPOSSIBLE");
		}else
			System.out.println(min);
		
		}
		}
	public static void fireQueueSet() {
		for(int i =0;i<h;i++) {
			for(int j =0;j<w;j++) {
				if(fireMap[i][j]==1&&!visited[i][j]) {
					fireQueue.offer(new PPair(i,j));
					visited[i][j]=true;
				}
			}
		}
	}
	public static void humanQueueSet() {
		for(int i =0;i<h;i++) {
			for(int j =0;j<w;j++) {
				if(humanMap[i][j]==1&&!visited[i][j]) {
					humanQueue.offer(new PPair(i,j));
					visited[i][j]=true;
				}
			}
		}
	}
	
	public static void bfs2() {
		while(!fireQueue.isEmpty()) {
			PPair pair = fireQueue.poll();
			int x = pair.x;
			int y = pair.y;
			if(isPossible(x+1,y)&&!visited[x+1][y]&&fireMap[x+1][y]!=-1) {
				fireQueue.offer(new PPair(x+1,y));
				fireMap[x+1][y]=fireMap[x][y]+1;
				visited[x+1][y]=true;
			}if(isPossible(x-1,y)&&!visited[x-1][y]&&fireMap[x-1][y]!=-1) {
				fireQueue.offer(new PPair(x-1,y));
				fireMap[x-1][y]=fireMap[x][y]+1;
				visited[x-1][y]=true;
			}if(isPossible(x,y+1)&&!visited[x][y+1]&&fireMap[x][y+1]!=-1) {
				fireQueue.offer(new PPair(x,y+1));
				fireMap[x][y+1]=fireMap[x][y]+1;
				visited[x][y+1]=true;
			}if(isPossible(x,y-1)&&!visited[x][y-1]&&fireMap[x][y-1]!=-1) {
				fireQueue.offer(new PPair(x,y-1));
				fireMap[x][y-1]=fireMap[x][y]+1;
				visited[x][y-1]=true;
			}
		}
	}
	
	public static void bfs() {
		while(!humanQueue.isEmpty()) {
			PPair pair = humanQueue.poll();
			int x = pair.x;
			int y = pair.y;
			if(isPossible(x+1,y)&&!visited[x+1][y]&&humanMap[x+1][y]!=-1) {
				humanMap[x+1][y]=humanMap[x][y]+1;
				if(fireMap[x+1][y]==0) {
					humanQueue.offer(new PPair(x+1,y));
				}
				else if(humanMap[x+1][y]<fireMap[x+1][y])
					humanQueue.offer(new PPair(x+1,y));
				else
					humanMap[x+1][y]=-1;
				visited[x+1][y]=true;
			}if(isPossible(x-1,y)&&!visited[x-1][y]&&humanMap[x-1][y]!=-1) {
				humanMap[x-1][y]=humanMap[x][y]+1;
				if(fireMap[x-1][y]==0) {
					humanQueue.offer(new PPair(x-1,y));
				}
				else if(humanMap[x-1][y]<fireMap[x-1][y]) 
					humanQueue.offer(new PPair(x-1,y));
				else
					humanMap[x-1][y]=-1;
				visited[x-1][y]=true;
			}if(isPossible(x,y+1)&&!visited[x][y+1]&&humanMap[x][y+1]!=-1) {
				humanMap[x][y+1]=humanMap[x][y]+1;
				if(fireMap[x][y+1]==0) {
					humanQueue.offer(new PPair(x,y+1));
				}
				else if(humanMap[x][y+1]<fireMap[x][y+1])
					humanQueue.offer(new PPair(x,y+1));
				else
					humanMap[x][y+1]=-1;
				visited[x][y+1]=true;
			}if(isPossible(x,y-1)&&!visited[x][y-1]&&humanMap[x][y-1]!=-1) {
				humanMap[x][y-1]=humanMap[x][y]+1;
				if(fireMap[x][y-1]==0) {
					humanQueue.offer(new PPair(x,y-1));
				}
				else if(humanMap[x][y-1]<fireMap[x][y-1])
					humanQueue.offer(new PPair(x,y-1));
				else
					humanMap[x][y-1]=-1;
				visited[x][y-1]=true;
			}
		}
	}
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=h||y<0||y>=w)
			return false;
		return true;
	}
	
	public static void print(int[][] arr) {
		for(int i =0;i<h;i++) {
			for(int j =0;j<w;j++) {
				if(arr[i][j]==-1)
					System.out.print("#");
				else 
					System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}
	
}
