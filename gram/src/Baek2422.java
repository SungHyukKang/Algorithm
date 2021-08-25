import java.util.*;
import java.io.*;

public class Baek2422 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] combi = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			combi[f][s] = true;
			combi[s][f] = true;
		}
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (combi[i][j] || combi[j][i])
					continue;
				for (int k = j + 1; k <= N; k++) {
					if (combi[j][k] || combi[i][k] || combi[k][j] || combi[k][i])
						continue;
					answer++;
				}
			}
		}
		System.out.println(answer);

	}

}
