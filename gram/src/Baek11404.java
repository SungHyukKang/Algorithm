import java.util.*;
import java.io.*;
public class Baek11404 {
	static int N;
	static int M;
	static final int INF = 99999999;
	static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		M = stoi(br.readLine());
		int[][] dist = new int[N+1][N+1];
		for(int i =1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				if(i==j)
					continue;
				dist[i][j]=INF;
			}
		}
		for(int i = 0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = stoi(st.nextToken()); 
			int num2 = stoi(st.nextToken()); 
			int num3 = stoi(st.nextToken());
			dist[num][num2]=Math.min(dist[num][num2], num3);
		}
		for(int k =1;k<=N;k++) {
			for(int i =1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					dist[i][j]=Math.min(dist[i][k]+dist[k][j],dist[i][j]);
				}
			}
		}

		for(int i =1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				if(dist[i][j]==INF)
					System.out.print("0 ");
				else
					System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
	}

}
