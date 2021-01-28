import java.util.*;
import java.io.*;

class Pair7562 {
	int x;
	int y;
	int cnt;

	public Pair7562(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Baek7562 {
	static int[] dx = { 1, 1, -1, -1, 2, 2, -2, -2 };
	static int[] dy = { -2, 2, -2, 2, 1, -1, 1, -1 };
	static int[][] arr;
	static boolean[][] visited;
	static Queue<Pair7562> q;
	static Pair7562 fin;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			q = new LinkedList<>();
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			q.offer(new Pair7562(x, y, 0));
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			fin = new Pair7562(x, y, 0);
			bfs();
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs()throws IOException {
		while (!q.isEmpty()) {
			Pair7562 p = q.poll();
			int x = p.x;
			int y = p.y;
			int cnt=p.cnt;
			if (x == fin.x && y == fin.y) {
				bw.write(cnt+"\n");
				break;
			}
			for (int i = 0; i < dx.length; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if(isPossible(nx,ny)) {
					q.offer(new Pair7562(nx,ny,cnt+1));
					visited[nx][ny]=true;
				}
			}
		}
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= arr.length || y < 0 || y >= arr.length)
			return false;
		
		if(visited[x][y])
			return false;
		
		return true;
	}
}
