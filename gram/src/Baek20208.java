import java.util.*;
import java.io.*;

public class Baek20208 {
	static int N, M, H;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[] visited;
	static int answer = 0;
	static int startW = 0;
	static int startH = 0;
	static List<int[]> pair = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					startW = i;
					startH = j;
				} else if (map[i][j] == 2) {
					pair.add(new int[] { i, j });
				}
			}
		}
		visited = new boolean[pair.size()];
		dfs(startW, startH, 0, M);
		System.out.println(answer);
	}

	public static void dfs(int x, int y, int count, int health) {
		if (Math.abs(x - startW) + Math.abs(y - startH) <= health) {
			answer = Math.max(answer, count);
		}
		int idx = 0;
		for (int[] p : pair) {
			int nx = p[0];
			int ny = p[1];
			if (visited[idx]) {
				idx++;
				continue;
			}
			if (Math.abs(x - nx) + Math.abs(y - ny) <= health) {
				visited[idx] = true;
				dfs(nx, ny, count + 1, health - (Math.abs(x - nx) + Math.abs(y - ny)) + H);
				visited[idx] = false;
			}
			idx++;
		}

	}

}