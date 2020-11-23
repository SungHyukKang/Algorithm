import java.util.*;
import java.io.*;

class Pair3187 {
	int x, y;

	Pair3187(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Baek3187 {
	static String[][] arr;
	static boolean[][] visited;
	static int[] nx = { 0, 0, 1, -1 };
	static int[] ny = { 1, -1, 0, 0 };
	static int x;
	static int y;
	static int k;
	static int v;
	static Queue<Pair3187> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		arr = new String[x][y];
		visited = new boolean[x][y];
		for (int i = 0; i < x; i++) {
			String X = br.readLine();
			int j = 0;
			for (String Z : X.split("")) {
				arr[i][j] = Z;
				j++;
			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (!arr[i][j].equals("#")&&!visited[i][j]) {
					visited[i][j] = true;
					q.offer(new Pair3187(i, j));
					bfs();
				}
			}
		}
		System.out.println(k + " " + v);
	}

	static void bfs() {
		int ks = 0;
		int vs = 0;
		if(arr[q.peek().x][q.peek().y].equals("k")) {
			ks++;
		}
		if(arr[q.peek().x][q.peek().y].equals("v")) {
			vs++;
		}
		while (!q.isEmpty()) {
			Pair3187 p = q.poll();
			int x = p.x;
			int y = p.y;
			for (int i = 0; i < nx.length; i++) {
				int mx = x + nx[i];
				int my = y + ny[i];
				if (isPossible(mx, my)) {
					q.offer(new Pair3187(mx, my));
					visited[mx][my] = true;
					if (arr[mx][my].equals("k")) {
						ks++;
					}
					if (arr[mx][my].equals("v")) {
						vs++;
					}
				}
			}
		}
		if (ks > vs) {
			k += ks;
		} else {
			v += vs;
		}
	}

	static boolean isPossible(int dx, int dy) {
		if (dx < 0 || dx >= x || dy < 0 || dy >= y) {
			return false;
		}

		if (arr[dx][dy].equals("#") || visited[dx][dy]) {
			return false;
		}

		return true;
	}
}
