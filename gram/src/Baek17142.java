import java.util.*;
import java.io.*;

class Pair17142 {
	int x;
	int y;
	int cnt;

	public Pair17142(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

}

public class Baek17142 {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static boolean[] virusVisited;
	static ArrayList<Pair17142> virus = new ArrayList<>();
	static Stack<Pair17142> stack = new Stack<>();
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int answer = 987654321;
	static int zeroCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					virus.add(new Pair17142(i, j, 0));
					arr[i][j] = -2;
				} else if (arr[i][j] == 1) {
					arr[i][j] = -1;
				} else
					zeroCnt++;
			}
		}
		if (zeroCnt == 0) {
			System.out.println(0);
			return;
		}
		virusVisited = new boolean[virus.size()];
		dfs(0, 0);
		System.out.println(answer == 987654321 ? -1 : answer);
	}

	public static void dfs(int depth, int idx) {
		if (depth == M) {
			int zero = zeroCnt;
			Queue<Pair17142> q = new LinkedList<>();
			visited = new boolean[N][N];
			for (int i = 0; i < stack.size(); i++) {
				q.offer(stack.get(i));
				visited[stack.get(i).x][stack.get(i).y] = true;
			}
			int max = 0;
			while (!q.isEmpty()) {
				Pair17142 p = q.poll();
				int x = p.x;
				int y = p.y;
				int cnt = p.cnt;
				boolean tf = true;
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + x;
					int ny = dy[i] + y;
					if (isPossible(nx, ny) && !visited[nx][ny] && arr[nx][ny] != -1) {
						q.offer(new Pair17142(nx, ny, cnt + 1));
						zero = arr[nx][ny] == 0 ? zero - 1 : zero;
						tf = false;
						visited[nx][ny] = true;
					}
				}
				if (tf && arr[x][y] == -2) {
					max = Math.max(max, cnt - 1);
				} else {
					max = Math.max(max, cnt);
				}
				if (zero == 0) {
					max = Math.max(max, cnt + 1);
					break;
				}
			}
			if (checkMap(arr)) {
				answer = Math.min(max, answer);
			}
			return;
		}
		for (int i = idx; i < virus.size(); i++) {
			if (!virusVisited[i]) {
				virusVisited[i] = true;
				stack.push(virus.get(i));
				dfs(depth + 1, i + 1);
				stack.pop();
				virusVisited[i] = false;
			}
		}
	}

	public static boolean checkMap(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;

		return true;
	}
}
