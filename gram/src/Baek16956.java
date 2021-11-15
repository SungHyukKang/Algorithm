import java.util.*;
import java.io.*;

public class Baek16956 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					for (int k = 0; k < 4; k++) {
						int nx = dx[k] + i;
						int ny = dy[k] + j;
						if (nx < 0 || nx >= R || ny < 0 || ny >= C)
							continue;
						if (map[nx][ny] == '.') {
							map[nx][ny] = 'D';
						} else if (map[nx][ny] == 'W') {
							System.out.println("0");
							return;
						}
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(1).append("\n");
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
