import java.util.*;
import java.io.*;

class Pair1389 {
	int idx;
	int D;

	public Pair1389(int idx, int d) {
		this.idx = idx;
		D = d;
	}
}

public class Baek1389 {
	static int N;
	static int M;
	final static int INF = 50000;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	static int[][] D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++)
				D[i][j] = INF;
		}
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		int min=21000000;
		int answer=0;
		for (int i = 1; i <= N; i++) {
			int sum=0;
			for (int j = 1; j <= N; j++)
				if (i != j) {
					sum+=D[i][j];
				}
			if(sum<min) {
				min=sum;
				answer=i;
			}
		}
		System.out.println(answer);
	}

	public static void bfs(int start) {
		Queue<Pair1389> q = new LinkedList<>();
		q.offer(new Pair1389(start, 0));
		while (!q.isEmpty()) {
			Pair1389 p = q.poll();
			int idx = p.idx;
			int d = p.D;
			for (int i : list.get(idx)) {
				if (D[start][i] > d + 1) {
					D[start][i] = d + 1;
					q.offer(new Pair1389(i, d + 1));
				}
			}
		}
	}

}
