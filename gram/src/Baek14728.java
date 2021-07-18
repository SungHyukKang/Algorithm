import java.util.*;
import java.io.*;

public class Baek14728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[] w = new int[N + 1];
		int[] v = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		int[][] arr = new int[N + 1][T + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= T; j++) {
				arr[i][j] = arr[i - 1][j];
				if (j >= w[i]) {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - w[i]] + v[i]);
				}
			}
		}
		System.out.println(arr[N][T]);
	}

}
