import java.util.*;
import java.io.*;

class Pair17141 {
	int x;
	int y;
	int cnt;

	public Pair17141(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

}

public class Baek17141 {
	static int N;
	static int M;
	static Stack<Integer> stack = new Stack<>();
	static boolean[][] visited;
	static boolean[] virus;
	static ArrayList<Pair17141> viruses = new ArrayList<>();
	static int[][] map;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int answer = 987654321;
	static int emptySpace = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					viruses.add(new Pair17141(i, j, 0));
				if (map[i][j] != 1)
					emptySpace++;
			}
		}
		emptySpace = emptySpace - M;
		virus = new boolean[viruses.size()];
		dfs(0, 0);
		if (answer == 987654321)
			System.out.println("-1");
		else
			System.out.println(answer);
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}

	public static void dfs(int depth, int idx) {
		if (depth == M) {
			Queue<Pair17141> q = new LinkedList<>();
			visited = new boolean[N][N];
			int space = -M;
			for (int i = 0; i < stack.size(); i++) {
				Pair17141 p = viruses.get(stack.get(i));
				q.offer(p);
				visited[p.x][p.y] = true;
			}
			int max = 0;
			while (!q.isEmpty()) {
				Pair17141 p = q.poll();
				int x = p.x;
				int y = p.y;
				int cnt = p.cnt;
				space++;
				max = Math.max(max, cnt);
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + x;
					int ny = dy[i] + y;
					if (isPossible(nx, ny) && map[nx][ny] != 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Pair17141(nx, ny, cnt + 1));
					}
				}

			}
			if (space == emptySpace)
				answer = Math.min(max, answer);
			return;

		}

		for (int i = idx; i < viruses.size(); i++) {
			if (!virus[i]) {
				virus[i] = true;
				stack.push(i);
				dfs(depth + 1, i + 1);
				stack.pop();
				virus[i] = false;

			}

		}

	}

}
