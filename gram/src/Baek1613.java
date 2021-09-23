import java.util.*;
import java.io.*;

public class Baek1613 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			map[s][e] = -1;
			map[e][s] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == k || k == j || i == j)
						continue;
					if (map[i][j] == 0) {
						if (map[i][k] == -1 && map[k][j] == -1) {
							map[i][j] = -1;
							map[j][i] = 1;
						} else if (map[j][k] == 1 && map[k][i] == 1) {
							map[i][j] = 1;
							map[j][i] = -1;
						}
					}
				}
			}
		}

		int S = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(map[s][e] + "\n");
		}
		System.out.println(sb);
	}

}
