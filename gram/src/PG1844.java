import java.util.*;

public class PG1844 {
	public static int solution(int[][] maps) {
		int answer = -1;
		int N = maps.length;
		int M = maps[0].length;
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 1 });
		int[] nx = { 0, 1, 0, -1 };
		int[] ny = { 1, 0, -1, 0 };
		while (!q.isEmpty()) {
			int[] dir = q.poll();
			int x = dir[0];
			int y = dir[1];
			int cnt = dir[2];
			if (x == maps.length - 1 && y == maps[0].length - 1) {
				return cnt;
			}
			for (int i = 0; i < 4; i++) {
				int dx = nx[i] + x;
				int dy = ny[i] + y;
				if (!(dx < 0 || dx >= N || dy < 0 || dy >= M) && !visited[dx][dy] && maps[dx][dy] != 0) {
					q.offer(new int[] { dx, dy, cnt + 1 });
					visited[dx][dy] = true;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {

	}

}
