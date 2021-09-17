import java.util.*;
import java.io.*;

public class Baek1941 {
	static char[][] map = new char[5][5];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[] visited = new boolean[25];
	static int cnt = 0;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		dfs(0, 0, 0);
		System.out.println(cnt);
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= 5 || y < 0 || y >= 5)
			return false;
		return true;
	}

	public static void dfs(int num, int depth, int dasom) {
		if (depth == 7) {
			if (dasom >= 4) {
				Queue<Integer> q = new LinkedList<>();
				q.offer(stack.get(0));
				int count = 0;
				boolean[][] check = new boolean[5][5];
				check[stack.get(0) / 5][stack.get(0) % 5] = true;
				while (!q.isEmpty()) {
					int n = q.poll();
					int x = n / 5;
					int y = n % 5;
					count++;
					for (int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if (isPossible(nx, ny) && !check[nx][ny] && visited[nx * 5 + ny]) {
							q.offer(nx * 5 + ny);
							check[nx][ny] = true;
						}
					}

				}
				if (count == 7)
					cnt++;
			}
			return;
		}

		for (int i = num; i < 25; i++) {
			if (!visited[i]) {
				visited[i] = true;
				stack.push(i);
				dfs(i, depth + 1, map[i / 5][i % 5] == 'S' ? dasom + 1 : dasom);
				stack.pop();
				visited[i] = false;
			}
		}

	}

}
