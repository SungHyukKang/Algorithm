import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class PairS12318 {
	int x, y, d;

	public PairS12318(int y, int x, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

}

class UserSolutionS12318 {
	static int[][] MAP;
	static PairS12318[] pairs;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N;

	public boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}

	public void bfs_init(int n, int[][] map) {

		MAP = map;
		N = n;

	}

	public int bfs(int x1, int y1, int x2, int y2) {
		pairs = new PairS12318[101];
		visited = new boolean[N][N];
		int pre = 0;
		int last = 0;
		x1--;
		y1--;
		pairs[pre] = new PairS12318(y1, x1, 0);
		x2--;
		y2--;
		visited[y1][x1] = true;
		int ans = -1;

		while (pairs[pre] != null) {
			PairS12318 p = pairs[pre];
			int x = p.x;
			int y = p.y;
			int d = p.d;
			if (x == x2 && y == y2) {
				ans = d;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if (isPossible(ny, nx) && !visited[ny][nx] && MAP[ny][nx] == 0) {
					last++;
					pairs[last] = new PairS12318(ny, nx, d + 1);
					visited[ny][nx] = true;
				}
			}
			pre++;
		}
		return ans;
	}

}

public class SWEA12318 {

	private final static UserSolutionS12318 usersolution = new UserSolutionS12318();

	private static BufferedReader br;

	private static int cmd_bfs() throws Exception {

		int score = 100;
		int N, M, x1, y1, x2, y2, dist, ans;
		int[][] map = new int[10][10];
		String str;
		StringTokenizer st;

		br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		N = Integer.parseInt(str);

		for (int i = 0; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		usersolution.bfs_init(N, map);

		str = br.readLine();
		M = Integer.parseInt(str);

		for (int i = 1; i <= M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			ans = Integer.parseInt(st.nextToken());

			dist = usersolution.bfs(x1, y1, x2, y2);
			if (dist != ans) {
				score = 0;
			}
		}
		return score;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("#total score : " + cmd_bfs());
	}
}