import java.util.*;
import java.io.*;

class Pair16197{
	int x,y;
	
	Pair16197(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class Baek16197 {
	static int N;
	static int M;
	static int[][] arr;
	static int[] nx = {0,0,1,-1};
	static int[] ny = {1,-1,0,0};
	static int answer =2100000000;
	static Queue<Pair16197> q = new LinkedList<>();
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		arr= new int[N][M];
		for(int i=0;i<N;i++) {
			String X =br.readLine();
			int j =0;
			for(String Z : X.split("")) {
				if(Z.equals(".")) {
					arr[i][j]=0;
				}else if(Z.equals("o")) {
					arr[i][j]=1;
					q.offer(new Pair16197(i,j));
				}else {
					arr[i][j]=-1;
				}
				j++;
			}
		}
		Pair16197 p1 = q.poll();
		Pair16197 p2 = q.poll();
		int x1 = p1.x;
		int y1 = p1.y;
		int x2 = p2.x;
		int y2 = p2.y;
		for(int i =0;i<nx.length;i++)
			dfs(x1, y1, x2, y2, 1,i);
		if(answer>10) {
			System.out.println("-1");
		}
		else
			System.out.println(answer);
	}
	static void dfs(int x1, int y1,int x2,int y2,int count,int pre) {
			if(answer<count) {
				return;
			}
			if(count>10) {
				answer=Math.min(answer, count);
				return;
			}
			int xx1=x1+nx[pre];
			int yy1=y1+ny[pre];
			int xx2=x2+nx[pre];
			int yy2=y2+ny[pre];
			if(isPossible(xx1,yy1)==false&&isPossible(xx2,yy2)==false) {
				return;
			}
			if(isPossible(xx1,yy1)==true&&isPossible(xx2,yy2)==false) {
				answer=Math.min(answer,count);
				return;
			}
			if(isPossible(xx1,yy1)==false&&isPossible(xx2,yy2)==true) {
				answer=Math.min(answer,count);
				return;
			}
			
			if(arr[xx1][yy1]==-1) {
				xx1=x1;
				yy1=y1;
			}
			if(arr[xx2][yy2]==-1) {
				xx2=x2;
				yy2=y2;
			}
			for(int i =0;i<4;i++) {
				dfs(xx1,yy1,xx2,yy2,count+1,i);
			}
		}
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) {
			return false;
		}
		return true;
	}
	
}
