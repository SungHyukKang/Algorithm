import java.util.*;
import java.io.*;

class Pair14497 {
	int x;
	int y;

	public Pair14497(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Baek14497 {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<Pair14497> q = new LinkedList<>();
	static Pair14497 ju;
	static Pair14497 bum;
	static int[] nx = { 0, 1, 0, -1 };
	static int[] ny = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		ju = new Pair14497(x1, y1);
		bum = new Pair14497(x2, y2);
		for(int i =1;i<=N;i++) {
			String[] Z= br.readLine().split("");
			for(int j=1;j<=M;j++) {
				if(Z[j-1].equals("#")||Z[j-1].equals("*")) {
					arr[i][j]=0;
				}else {
					arr[i][j]=Integer.parseInt(Z[j-1]);
				}
					
			}
		}
		int cnt=0;
		visited = new boolean[N + 1][M + 1];
		while (!visited[x2][y2]) {
			visited = new boolean[N + 1][M + 1];
			visited[x1][y1] = true;
			q.offer(new Pair14497(x1,y1));
			bfs();
			cnt++;
		}
		System.out.println(cnt);
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Pair14497 p = q.poll();
			int x = p.x;
			int y = p.y;
			if(arr[x][y]==1) {
				arr[x][y]=0;
				continue;
			}
			for(int i =0;i<nx.length;i++) {
				int dx = nx[i]+x;
				int dy= ny[i]+y;
				if(isPossible(dx,dy)) {
					q.offer(new Pair14497(dx,dy));
					visited[dx][dy]=true;
				}
			}
		}
	}

	public static boolean isPossible(int x, int y) {
		if (x <= 0 || x > N || y <= 0 || y > M)
			return false;
		if (visited[x][y])
			return false;
		return true;
	}
}
