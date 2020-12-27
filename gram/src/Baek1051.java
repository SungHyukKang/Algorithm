import java.util.*;
import java.io.*;
public class Baek1051 {
	public static void main(String[] args)throws IOException {
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		int arr[][] =new int[N][M];
		for(int i =0;i<N;i++) {
			int j=0;
			String X =br.readLine();
			for(String x: X.split("")) {
				arr[i][j]=Integer.parseInt(x);
				j++;
			}
		}
		int max=0;
		int min=Math.min(N, M);
		for(int  s=min;s>=1;s--) {
			for(int w=0;w<=N-s;w++) {
				for(int h=0;h<=M-s;h++) {
					int[][] map = new int[s][s];
					for(int i =w;i-w<s;i++) {
						for(int j=h;j-h<s;j++) {
							map[i-w][j-h]=arr[i][j];
						}
					}
					int z=map[0][0];
					int x=map[s-1][s-1];
					int c=map[s-1][0];
					int v=map[0][s-1];
					if(z==x&&z==c&&z==v) {
						if(max<s*s) {
							max=s*s;
						}
					}
				}
			}
		}
		System.out.println(max);
		
	}
}
