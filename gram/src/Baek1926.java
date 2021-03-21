import java.util.*;
import java.io.*;

public class Baek1926 {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					cnt++;
					visited[i][j] = true;
					ans = 1;
					dfs(i, j, 0);
					max = Math.max(max, ans);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

	public static void dfs(int x, int y, int cnt) {

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
				continue;
			}
			if (arr[nx][ny] == 1) {
				visited[nx][ny] = true;
				dfs(nx, ny, cnt + 1);
				ans++;
			}
		}

	}

}
