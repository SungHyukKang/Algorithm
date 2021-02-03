import java.util.*;
import java.io.*;

class Pair6593 {
	int x, y, z;

	public Pair6593(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

}

public class Baek6593 {
	static int L;
	static int R;
	static int C;
	static int[][][] arr;
	static boolean[][][] visited;
	static Queue<Pair6593> q;
	static Pair6593 fin;
	static int[] nx = { 0, 0, 0, 1, 0, -1 };
	static int[] ny = { 0, 0, -1, 0, 1, 0 };
	static int[] nz = { 1, -1, 0, 0, 0, 0 };
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L == 0 && R == 0 && C == 0) {
				break;
			}
			q = new LinkedList<>();
			arr = new int[L][R][C];
			visited = new boolean[L][R][C];
			fin = null;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String X = br.readLine();
					for (int k = 0; k < C; k++) {
						if (X.charAt(k) == 'S') {
							q.offer(new Pair6593(j, k, i));
							visited[i][j][k] = true;
						} else if (X.charAt(k) == '#') {
							arr[i][j][k] = -1;
						} else if (X.charAt(k) == 'E') {
							fin = new Pair6593(j, k, i);
							arr[i][j][k] = -2;
						} else {
							arr[i][j][k] = 0;
						}
					}
				}
				br.readLine();
			}
			bfs();
			if (arr[fin.z][fin.x][fin.y] == -2||arr[fin.z][fin.x][fin.y]>60) {
				bw.write("Trapped!");
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs() throws IOException {
		while (!q.isEmpty()) {
			print();
			Pair6593 p = q.poll();
			int x = p.x;
			int y = p.y;
			int z = p.z;
			if (arr[z][x][y] > 60) {
				continue;
			}
			if (x == fin.x && y == fin.y && z == fin.z) {
				bw.write("Escaped in " + arr[z][x][y] + " minute(s).");
				bw.write("\n");
				break;
			}
			for (int i = 0; i < nx.length; i++) {
				int dx = nx[i] + x;
				int dy = ny[i] + y;
				int dz = nz[i] + z;
				if (isPossible(dx, dy, dz) && arr[dz][dx][dy] != -1) {
					q.offer(new Pair6593(dx, dy, dz));
					arr[dz][dx][dy] = arr[z][x][y] + 1;
					visited[dz][dx][dy] = true;
				}
			}
		}
	}

	public static void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int j2 = 0; j2 < arr[i][j].length; j2++) {
					System.out.print(arr[i][j][j2] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("-----------------------------------");
	}

	public static boolean isPossible(int x, int y, int z) {
		if (x < 0 || x >= R || y < 0 || y >= C || z < 0 || z >= L) {
			return false;
		}
		if (visited[z][x][y]) {
			return false;
		}
		return true;
	}
}
