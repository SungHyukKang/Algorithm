import java.util.*;
import java.io.*;

public class Baek2303 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][5];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		int sum = 0;
		for (int idx = 0; idx < N; idx++) {
			for (int i = 0; i < 5; i++) {
				for (int j = i + 1; j < 5; j++) {
					for (int k = j + 1; k < 5; k++) {
						if (sum <= (arr[idx][i] + arr[idx][j] + arr[idx][k]) % 10) {
							sum = (arr[idx][i] + arr[idx][j] + arr[idx][k]) % 10;
							ans = idx;
						}
					}
				}
			}
		}
		System.out.println(ans + 1);

	}

}
