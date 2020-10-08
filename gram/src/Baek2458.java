	import java.util.*;
	import java.io.*;
	public class Baek2458 {
		static final int INF=999;
		public static int stoi(String X) {return Integer.parseInt(X);}
		public static void main(String[] args)throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N =stoi(st.nextToken());
			int M=stoi(st.nextToken());
			int[][] arr =new int[N+1][N+1];
			
			
			for(int i =0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int num =stoi(st.nextToken());
				int num2 =stoi(st.nextToken());
				arr[num][num2]=1;
			}
			
			for(int k = 1;k<=N;k++) {
				for(int i=1;i<=N;i++) {
					for(int j =1;j<=N;j++) {
						if(arr[i][k]==1&&arr[k][j]==1)
							arr[i][j]=1;
					}
				}
			}
			
			int cnt=N;
			for(int i =1;i<=N;i++) {
				for(int j =1;j<=N;j++) {
					if(i==j)continue;
					if(arr[i][j]==0&&arr[j][i]==0) {
						cnt--;
						break;
					}
						
				}
			}
			System.out.println(cnt);
		}
	}
