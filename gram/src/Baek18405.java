import java.util.*;
import java.io.*;

class Pair18405 {
	int x, y, virus;

	public Pair18405(int x, int y, int virus) {
		this.x = x;
		this.y = y;
		this.virus = virus;
	}

	@Override
	public String toString() {
		return "Pair18405 [x=" + x + ", y=" + y + ", virus=" + virus + "]";
	}

}

public class Baek18405 {
	static Queue<Pair18405> q;
	static int[] nx = { 0, 1, 0, -1 };
	static int[] ny = { 1, 0, -1, 0 };
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static ArrayList<Pair18405> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int targetX = Integer.parseInt(st.nextToken());
		int targetY = Integer.parseInt(st.nextToken());
		int cnt = 0;
		while (true) {
			if (cnt == S) {
				System.out.println(arr[targetX][targetY]);
				break;
			}
			q = new LinkedList<>();
			list = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (arr[i][j] != 0 && !visited[i][j]) {
						q.offer(new Pair18405(i, j, arr[i][j]));
						visited[i][j] = true;
						bfs();
					}
				}
			}
			Collections.sort(list, new Comparator<Pair18405>() {
				@Override
				public int compare(Pair18405 o1, Pair18405 o2) {
					return Integer.compare(o1.virus, o2.virus);
				}
			});
			for (Pair18405 p : list) {
				int x = p.x;
				int y = p.y;
				int v = p.virus;
				if (arr[x][y] > v && !visited[x][y]) {
					arr[x][y] = v;
				} else if (arr[x][y] == 0)
					arr[x][y] = v;
			}
			cnt++;
		}
	}

	public static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Pair18405 p = q.poll();
			int x = p.x;
			int y = p.y;
			int v = p.virus;
			for (int i = 0; i < 4; i++) {
				int dx = nx[i] + x;
				int dy = ny[i] + y;
				if (isPossible(dx, dy) && !visited[dx][dy]) {
					list.add(new Pair18405(dx, dy, v));
				}
			}
		}
	}

	public static boolean isPossible(int x, int y) {
		if (x <= 0 || x > N || y <= 0 || y > N) {
			return false;
		}
		return true;
	}
}
