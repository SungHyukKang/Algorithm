import java.util.*;
import java.io.*;

class Pair19238 implements Comparable<Pair19238> {
	int idx;
	int x;
	int y;
	int f;
	int d;

	Pair19238(int idx, int x, int y, int f, int d) {
		this.idx = idx;
		this.x = x;
		this.y = y;
		this.f = f;
		this.d = d;
	}

	@Override
	public int compareTo(Pair19238 o) {
		if (this.d < o.d)
			return -1;
		else if (this.d == o.d) {
			if (this.x < o.x) {
				return -1;
			} else if (this.x == o.x) {
				if (this.y < o.y)
					return -1;
				else
					return 1;
			} else
				return 1;
		} else
			return 1;
	}
}

public class Baek19238 {
	static boolean[][] visited;
	static int n;
	static int m;
	static int f;
	static int[][] arr;
	static int[][] mapH;
	static int[][][] mapD;
	static int[] nx = { -1, 0, 0, 1 };
	static int[] ny = { 0, -1, 1, 0 };
	static int hm;
	static PriorityQueue<Pair19238> q = new PriorityQueue<>();

	public static int stoi(String X) {
		return Integer.parseInt(X);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		f = stoi(st.nextToken());
		arr = new int[n + 1][n + 1];
		mapH = new int[n + 1][n + 1];
		mapD = new int[403][n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int j = 1;
			while (st.hasMoreTokens()) {
				int x = stoi(st.nextToken());
				if (x == 1)
					arr[i][j] = -5000;
				else
					arr[i][j] = x;
				j++;
			}
		}
		st = new StringTokenizer(br.readLine());
		q.offer(new Pair19238(0, stoi(st.nextToken()), stoi(st.nextToken()), f, 0));
		visited[q.peek().x][q.peek().y] = true;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken());
			int y = stoi(st.nextToken());
			int dx = stoi(st.nextToken());
			int dy = stoi(st.nextToken());
			mapH[x][y] = i + 1;
			mapD[i + 1][dx][dy] = i + 1;
		}
		while (!q.isEmpty()) {
			Pair19238 p = q.poll();
			int idx = p.idx;
			int x = p.x;
			int y = p.y;
			int ff = p.f;
			int d = p.d;
			if (idx==0&&mapH[x][y]!=0) {
				q = new PriorityQueue<>();
				q.offer(new Pair19238(mapH[x][y], x, y, ff, d));
				visited = new boolean[n + 1][n + 1];
				visited[x][y] = true;
				f=ff;
				mapH[x][y] = 0;
				continue;
			}
			if (mapD[idx][x][y] == idx && idx != 0) {
				if(ff<0) {
					break;
				}
				mapD[idx][x][y] = 0;
				f=ff+(f-ff)*2;
				q = new PriorityQueue<Pair19238>();
				q.offer(new Pair19238(0, x, y, f, d));
				visited = new boolean[n + 1][n + 1];
				visited[x][y] = true;
				m--;
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int mx = nx[i] + x;
				int my = ny[i] + y;
				if (isPossible(mx, my) && arr[mx][my] != -5000) {
					visited[mx][my] = true;
					q.offer(new Pair19238(idx, mx, my, ff - 1, d + 1));
				}
			}
		}
		if(m>0)
			System.out.println("-1");
		else
			System.out.println(f);
	}

	public static boolean isPossible(int x, int y) {
		if (x < 1 || x > n || y < 1 || y > n) {
			return false;
		}
		if (visited[x][y])
			return false;
		return true;
	}
}