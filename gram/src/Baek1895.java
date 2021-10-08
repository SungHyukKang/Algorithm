import java.util.*;
import java.io.*;

public class Baek1895 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] image = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				image[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int T = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i <= R - 3; i++) {
			for (int j = 0; j <= C - 3; j++) {
				int idx = 0;
				int[] filtering = new int[9];
				for (int k = 0; k < 3; k++) {
					for (int z = 0; z < 3; z++) {
						filtering[idx++] = image[i + k][z + j];
					}
				}
				Arrays.sort(filtering);
				if (filtering[4] >= T) {
					answer++;
				}
			}
		}
		System.out.println(answer);

	}

}
