import java.util.*;
import java.io.*;

class Pair8976 {
	int x, y, cnt;

	public Pair8976(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

}

public class Baek8976 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[8][8];
		int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int i = 0; i < 8; i++) {
			String X = br.readLine();
			for (int j = 0; j < 8; j++) {
				char c = X.charAt(j);
				if (c == 'B') {
					arr[i][j] = 1;
				} else if (c == 'W') {
					arr[i][j] = 2;
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (arr[i][j] == 0) {
					int cnt = 0;
					for (int z = 0; z < 8; z++) {
						int nx = dx[z] + i;
						int ny = dy[z] + j;
						int sum = 0;
						while (isPossible(nx, ny) && arr[nx][ny] == 2) {
							nx += dx[z];
							ny += dy[z];
							sum++;
							if (!isPossible(nx, ny))
								break;
							if (arr[nx][ny] == 1) {
								cnt += sum;
								break;
							}
						}
						answer = Math.max(answer, cnt);
					}
				}
			}
		}
		System.out.println(answer);

	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= 8 || y < 0 || y >= 8)
			return false;
		return true;
	}

}
