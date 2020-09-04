
import java.util.*;
import java.io.*;

class Pairs{
	int x;
	int y;
	Pairs(int x ,int y){
		this.x=x;
		this.y=y;
	}
}

public class Baek3055 {
	public static int N;
	public static int M;
	public static int[][] bMap;
	public static int[][] wMap;
	public static Queue<Pairs> wQ=new LinkedList<>();
	public static Queue<Pairs> bQ=new LinkedList<>();
	public static boolean[][] visited;
	public static Pairs D ;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Z = br.readLine();
		N=Integer.parseInt(Z.split(" ")[0]);
		M=Integer.parseInt(Z.split(" ")[1]);
		bMap= new int[N][M];
		wMap= new int[N][M];
		for(int i =0;i<N;i++) {
			int j =0;
			Z=br.readLine();
			for(String X : Z.split("")) {
				if(X.equals(".")) {
					bMap[i][j]=0;
					wMap[i][j]=0;
					j++;
				}else if(X.equals("X")) {
					bMap[i][j]=-1;
					wMap[i][j]=-1;
					j++;
				}else if(X.equals("*")) {
					wMap[i][j]=1;
					bMap[i][j]=-1;
					j++;
				}else if(X.equals("S")) {
					bMap[i][j]=1;
					wMap[i][j]=0;
					j++;
				}else {
					bMap[i][j]=-2;
					wMap[i][j]=-2;
					D=new Pairs(i,j);
					j++;
				}
			}
		}
		visited=new boolean[N][M];
		wSet();
		bfsW();
		visited=new boolean[N][M];
		bSet();
		bfsB();
		
		bMap[D.x][D.y]=1000001;
		if(isPossible(D.x+1,D.y)) {
			if(wMap[D.x+1][D.y]>wMap[D.x][D.y]&&wMap[D.x+1][D.y]>0) {
				wMap[D.x][D.y]=wMap[D.x+1][D.y];
			}if(bMap[D.x+1][D.y]<bMap[D.x][D.y]&&bMap[D.x+1][D.y]>0) {
				bMap[D.x][D.y]=bMap[D.x+1][D.y];
			}
		}if(isPossible(D.x-1,D.y)) {
			if(wMap[D.x-1][D.y]>wMap[D.x][D.y]&&wMap[D.x-1][D.y]>0) {
				wMap[D.x][D.y]=wMap[D.x-1][D.y];
			}if(bMap[D.x-1][D.y]<bMap[D.x][D.y]&&bMap[D.x-1][D.y]>0) {
				bMap[D.x][D.y]=bMap[D.x-1][D.y];
			}
		}if(isPossible(D.x,D.y+1)) {
			if(wMap[D.x][D.y+1]>wMap[D.x][D.y]&&wMap[D.x][D.y+1]>0) {
				wMap[D.x][D.y]=wMap[D.x][D.y+1];
			}if(bMap[D.x][D.y+1]<bMap[D.x][D.y]&&bMap[D.x][D.y+1]>0) {
				bMap[D.x][D.y]=bMap[D.x][D.y+1];
			}
		}if(isPossible(D.x,D.y-1)) {
			if(wMap[D.x][D.y-1]>wMap[D.x][D.y]&&wMap[D.x][D.y-1]>0) {
				wMap[D.x][D.y]=wMap[D.x][D.y-1];
			}if(bMap[D.x][D.y-1]<bMap[D.x][D.y]&&bMap[D.x][D.y-1]>0) {
				bMap[D.x][D.y]=bMap[D.x][D.y-1];
			}
		}
		if(wMap[D.x][D.y]==-2) {
			if(bMap[D.x][D.y]==-2) {
				System.out.println("KAKTUS");
			}else
				System.out.println(bMap[D.x][D.y]);
		}else if(wMap[D.x][D.y]>bMap[D.x][D.y]) {
			System.out.println(bMap[D.x][D.y]);
		}else
			System.out.println("KAKTUS");
			
		
		
	}
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) {
			return false;
		}
		return true;
	}
	
	public static void bfsB(){
		while(!bQ.isEmpty()) {
			Pairs pair = bQ.poll();
			int x = pair.x;
			int y = pair.y;
			if(bMap[x][y]==-2) {
				break;
			}
 			if(isPossible(x+1,y)&&!visited[x+1][y]&&bMap[x+1][y]>=0) {
				bMap[x+1][y]=bMap[x][y]+1;
				if(wMap[x+1][y]==0) {
					bQ.offer(new Pairs(x+1,y));
				}
				else if(wMap[x+1][y]>bMap[x+1][y]) {
					bQ.offer(new Pairs(x+1,y));
				}else{
					bMap[x+1][y]=-1;
				}
				visited[x+1][y]=true;
			}if(isPossible(x-1,y)&&!visited[x-1][y]&&bMap[x-1][y]>=0) {
				bMap[x-1][y]=bMap[x][y]+1;
				if(wMap[x-1][y]==0) {
					bQ.offer(new Pairs(x-1,y));
				}
				else if(wMap[x-1][y]>bMap[x-1][y]) {
					bQ.offer(new Pairs(x-1,y));
				}else{
					bMap[x-1][y]=-1;
				}
				visited[x-1][y]=true;
				
			}if(isPossible(x,y+1)&&!visited[x][y+1]&&bMap[x][y+1]>=0) {
				bMap[x][y+1]=bMap[x][y]+1;
				if(wMap[x][y+1]==0) {
					bQ.offer(new Pairs(x,y+1));
				}
				else if(wMap[x][y+1]>bMap[x][y+1]) {
					bQ.offer(new Pairs(x,y+1));
				}else{
					bMap[x][y+1]=-1;
				}
				visited[x][y+1]=true;
				
			}if(isPossible(x,y-1)&&!visited[x][y-1]&&bMap[x][y-1]>=0) {
				bMap[x][y-1]=bMap[x][y]+1;
				if(wMap[x][y-1]==0) {
					bQ.offer(new Pairs(x,y-1));
				}
				else if(wMap[x][y-1]>bMap[x][y-1]) {
					bQ.offer(new Pairs(x,y-1));
				}else{
					bMap[x][y-1]=-1;
				}
				visited[x][y-1]=true;
			}
		}
	}
	
	public static void bfsW() {
		while(!wQ.isEmpty()) {
			Pairs pair = wQ.poll();
			int x = pair.x;
			int y = pair.y;
			if(isPossible(x+1,y)&&!visited[x+1][y]&&wMap[x+1][y]>=0) {
				wMap[x+1][y]=wMap[x][y]+1;
				wQ.offer(new Pairs(x+1,y));
				visited[x+1][y]=true;
			}if(isPossible(x-1,y)&&!visited[x-1][y]&&wMap[x-1][y]>=0) {
				wMap[x-1][y]=wMap[x][y]+1;
				wQ.offer(new Pairs(x-1,y));
				visited[x-1][y]=true;
				
			}if(isPossible(x,y+1)&&!visited[x][y+1]&&wMap[x][y+1]>=0) {
				wMap[x][y+1]=wMap[x][y]+1;
				wQ.offer(new Pairs(x,y+1));
				visited[x][y+1]=true;
				
			}if(isPossible(x,y-1)&&!visited[x][y-1]&&wMap[x][y-1]>=0) {
				wMap[x][y-1]=wMap[x][y]+1;
				wQ.offer(new Pairs(x,y-1));
				visited[x][y-1]=true;
				
			}
			
		}
	}
	public static void bSet() {
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
			if(bMap[i][j]==1) {
				bQ.offer(new Pairs(i,j));
				visited[i][j]=true;
				break;
			}
			}
		}
	}
	public static void wSet() {
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(wMap[i][j]==1) {
					wQ.offer(new Pairs(i,j));
					visited[i][j]=true;
				}
			}
		}
	}
	public static void print(int arr[][]) {
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(arr[i][j]==-1)
				System.out.print(arr[i][j]+" ");
				else
					System.out.print(" "+arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}
	
}
