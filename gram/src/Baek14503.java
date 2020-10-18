import java.util.*;
import java.io.*;

class Node14503{
	int x;
	int y;
	int d;
	
	Node14503(int x, int y,int d){
		this.x=x;
		this.y=y;
		this.d=d;
	}
}

public class Baek14503 {
	public static int N;
	public static int M;
	public static int r;
	public static int c;
	public static int d;
	public static int[][] arr;
	public static int[] nx = {0,1,0,-1};
	public static int[] ny = {-1,0,1,0};
	public static boolean[][] visited;
	public static Queue<Node14503> q=new LinkedList<>();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		st= new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		q.offer(new Node14503(r,c,d));
		visited[r][c]=true;
		int ans =1;
		for(int i =0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j =0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}//0 북 , 1 동 , 2 남 ,3 서
		while(!q.isEmpty()) {
			Node14503 n = q.poll();
			int x = n.x;
			int y = n.y;
			int d = n.d;
			System.out.println(x+" "+y+ " "+d);
			int cnt=0;
			while(cnt<4) {
				int dcnt=d+cnt;
				if(dcnt>=nx.length) {
					dcnt=Math.abs(nx.length-dcnt);
				}
				int mx = x+nx[dcnt];
				int my = y+ny[dcnt];
				if(isPossible(mx,my)&&!visited[mx][my]) {
					dcnt = dcnt+1 > 3 ? 0 : dcnt+1;
					q.offer(new Node14503(mx,my,dcnt));
					visited[mx][my]=true;
					ans++;
					break;
				}
				cnt++;
			}
			if(q.isEmpty()) {
				int mx=x;
				int my=y;
				if(d==0) {
					mx += 1;
				}else if(d==1) {
					my+=1;
				}else if(d==2) {
					mx-=1;
				}else if(d==3) {
					my-=1;
				}
				if(isPossible(mx,my)) {
					q.offer(new Node14503(mx,my,d));
					if(!visited[mx][my]) {
						visited[mx][my]=true;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) {
			return false;
		}
		if(arr[x][y]==1)
			return false;
		return true;
	}
}
