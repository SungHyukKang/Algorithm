import java.util.*;
import java.io.*;

public class Baek2096 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] dpmax = new int[N][3];
		int[][] dpmin = new int[N][3];

		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 3; i++) {
			dpmax[0][i] = arr[0][i];
			dpmin[0][i] = arr[0][i];
		}
		int max = 0;
		int min = 21000000;
		for (int i = 1; i < N; i++) {
			dpmax[i][0] = Math.max(dpmax[i - 1][0] + arr[i][0], dpmax[i - 1][1] + arr[i][0]);
			dpmax[i][1] = Math.max(dpmax[i - 1][2] + arr[i][1],
					Math.max(dpmax[i - 1][0] + arr[i][1], dpmax[i - 1][1] + arr[i][1]));
			dpmax[i][2] = Math.max(dpmax[i - 1][1] + arr[i][2], dpmax[i - 1][2] + arr[i][2]);
			dpmin[i][0] = Math.min(dpmin[i - 1][0] + arr[i][0], dpmin[i - 1][1] + arr[i][0]);
			dpmin[i][1] = Math.min(dpmin[i - 1][2] + arr[i][1],
					Math.min(dpmin[i - 1][0] + arr[i][1], dpmin[i - 1][1] + arr[i][1]));
			dpmin[i][2] = Math.min(dpmin[i - 1][1] + arr[i][2], dpmin[i - 1][2] + arr[i][2]);
		}
		max = Math.max(Math.max(dpmax[N - 1][0], dpmax[N - 1][1]), dpmax[N - 1][2]);
		min = Math.min(Math.min(dpmin[N - 1][0], dpmin[N - 1][1]), dpmin[N - 1][2]);
		bw.write(max + " " + min);
		bw.flush();
		bw.close();
		br.close();

	}

}
