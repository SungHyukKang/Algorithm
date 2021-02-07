import java.util.*;
import java.io.*;

class Point16236 {
	int x;
	int y;
	int d;

	public Point16236(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class Baek16236 {
	static int N;
	static int arr[][];
	static boolean visited[][];
	static int[] nx = { -1, 0, 1, 0 };
	static int[] ny = { 0, -1, 0, 1 };
	static int time = 0;
	static int eat = -1;
	static int size = 2;
	static Queue<Point16236> q = new LinkedList<>();
	static ArrayList<Point16236> list = new ArrayList<>();

	public static int stoi(String x) {
		return Integer.parseInt(x);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = stoi(st.nextToken());
				if (arr[i][j] == 9) {
					arr[i][j] = 0;
					list.add(new Point16236(i, j, 0));
				}
			}
		}
		while (true) {
			if (list.size() < 1) {
				bw.write(time + "");
				break;
			}
			Collections.sort(list, new Comparator<Point16236>() {
				@Override
				public int compare(Point16236 arg0, Point16236 arg1) {
					if (arg0.d < arg1.d) {
						return -1;
					} else if (arg0.d == arg1.d) {
						if (arg0.x < arg1.x)
							return -1;
						else if (arg0.x == arg1.x) {
							if (arg0.y < arg1.y)
								return -1;
							else
								return 1;
						} else
							return 1;
					} else
						return 1;
				}
			});
			q = new LinkedList<>();
			if (eat + 1 == size) {
				size++;
				eat = 0;
			} else {
				eat++;
			}
			time += list.get(0).d;
			q.offer(new Point16236(list.get(0).x, list.get(0).y, 0));
			arr[list.get(0).x][list.get(0).y] = 0;
			visited = new boolean[N][N];
			visited[list.get(0).x][list.get(0).y] = true;
			list = new ArrayList<>();
			bfs();
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Point16236 p = q.poll();
			int x = p.x;
			int y = p.y;
			int t = p.d;
			for (int i = 0; i < 4; i++) {
				int dx = nx[i] + x;
				int dy = ny[i] + y;
				if (isPossible(dx, dy) && !visited[dx][dy] && arr[dx][dy] <= size) {
					if (arr[dx][dy] < size && arr[dx][dy] != 0) {
						list.add(new Point16236(dx, dy, t + 1));
					}
					q.offer(new Point16236(dx, dy, t + 1));
					visited[dx][dy] = true;
				}
			}
		}
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}

}
