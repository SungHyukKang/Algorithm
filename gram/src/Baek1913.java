import java.util.*;
import java.io.*;

public class Baek1913 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int find = Integer.parseInt(br.readLine());
		int startx = N / 2;
		int starty = N / 2;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int cnt = 1;
		int d = 0;
		int num = 1;
		int fx = startx;
		int fy = starty;
		map[startx][starty] = num++;
		while (true) {
			if (startx == 0 && starty == 0)
				break;
			for (int i = 0; i < cnt; i++) {
				if (startx == 0 && starty == 0)
					break;
				startx = startx + dx[d];
				starty = starty + dy[d];
				if (num == find) {
					fx = startx;
					fy = starty;
				}
				map[startx][starty] = num++;
			}
			d++;
			for (int i = 0; i < cnt; i++) {
				if (startx == 0 && starty == 0)
					break;
				startx = startx + dx[d];
				starty = starty + dy[d];
				if (num == find) {
					fx = startx;
					fy = starty;
				}
				map[startx][starty] = num++;
			}
			d++;
			if (d == 4) {
				d = 0;
			}
			cnt++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		sb.append((fx + 1) + " " + (fy + 1));
		System.out.println(sb.toString());
	}

}
