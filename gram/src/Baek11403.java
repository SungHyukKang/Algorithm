import java.util.*;
import java.io.*;
public class Baek11403 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N =Integer.parseInt(br.readLine());
		int[][] arr =new int[N][N];
		for(int i =0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int k=0;k<N;k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]==0&&(arr[i][k]+arr[k][j])==2) {
						arr[i][j]=1;
					}
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
