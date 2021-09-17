import java.util.*;
import java.io.*;

public class Baek1507 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		boolean[][] visited = new boolean[N][N];
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == k || j == k || i == j)
						continue;
					else if (map[i][j] > map[i][k] + map[k][j]) {
						System.out.println(-1);
						return;
					} else if (map[i][j] == map[i][k] + map[k][j]) {
						visited[i][j] = true;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					answer += map[i][j];
				}
			}
		}
		System.out.println(answer / 2);

	}

}
