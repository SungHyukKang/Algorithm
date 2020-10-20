import java.util.*;
import java.io.*;

class FB{
	int r,c,m,s,d;
	
	FB(int r, int c,int m ,int s , int d){
		this.r=r;
		this.s=s;
		this.m=m;
		this.c=c;
		this.d=d;
	}
	
	
}


public class Baek20056 {
	static int N;
	static int M;
	static int K;
	static int[][] arr;
	static int[] nx= {-1,-1,0,1,1,1,0,-1};
	static int[] ny= {0,1,1,1,0,-1,-1,-1};
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		K=stoi(st.nextToken());
		HashMap<Integer,FB> fb =new HashMap<>();
		int lastIdx=0;
		for(int i =0;i<M;i++) {
			st= new StringTokenizer(br.readLine());
			fb.put(i,new FB(stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken())));
			lastIdx++;
		}
		for(int k =0;k<K;k++) {
		ArrayList<Integer>[][] list = new ArrayList[N+1][N+1];
		for(int i =1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				list[i][j]=new ArrayList<>();
			}
		}
			for(int i : fb.keySet()) {
				FB fire =fb.get(i);
				int r= fire.r;
				int c= fire.c;
				int x =r+nx[fire.d]*fire.s;
				int y =c+ny[fire.d]*fire.s;
				while(x<1) x+=N;
				while(y<1) y+=N;
				while(x>N) x-=N;
				while(y>N) y-=N;
				fb.get(i).r=x;
				fb.get(i).c=y;
				list[x][y].add(i);
			}
			
			for(int x= 1;x<=N;x++) {
				for(int y=1;y<=N;y++) {
					int sumM=0;
					int sumS=0;
					boolean true1=false;
					boolean true2=false;
					int dir=0;
					int size = list[x][y].size();
					if(size>=2) {
						for(int X :list[x][y]) {
							FB fire = fb.get(X);
							sumM+=fire.m;
							sumS+=fire.s;
							if(fire.d%2==0) {
								true1=true;
							}else
								true2=true;
							fb.remove(X);
						}
						if(true1&&true2)
							dir=1;
						
						sumM=sumM/5;
						sumS=sumS/size;
						if(sumM==0)
							continue;
						for(int v=0;v<4;v++) {
							lastIdx++;
							fb.put(lastIdx,new FB(x,y,sumM,sumS,v*2+dir));
						}
					}
				}
			}
		}
		int ans=0;
		for(FB X : fb.values()) {
			ans+=X.m;
		}
		System.out.println(ans);
	}
}
