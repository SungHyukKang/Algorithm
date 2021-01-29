import java.util.*;
import java.io.*;

class Pair6118 {
	int n;
	int d;

	public Pair6118(int n, int d) {
		this.n = n;
		this.d = d;
	}

}

public class Baek6118 {
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int[] D;
	static Queue<Pair6118> q = new LinkedList<>();
	final static int INF = 2100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			D[i] = INF;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}
		bfs();
		int max = 0;
		for (int i = 1; i <= N; i++)
			max = Math.max(max, D[i]);
		int cnt = 0;
		boolean tf =true;
		for (int i = 1; i <= N; i++) {
			if (max == D[i]) {
				if(tf)
					System.out.print(i + " " + D[i] + " ");
				tf=false;
				cnt++;
			}
		}
		System.out.print(cnt);
	}

	public static void bfs() {
		q.offer(new Pair6118(1, 0));
		D[1] = 0;
		while (!q.isEmpty()) {
			Pair6118 p = q.poll();
			int n = p.n;
			int d = p.d;
			if (d > D[n])
				continue;
			for (int node : list.get(n)) {
				if (D[node] > d + 1) {// 1- > 2 -> 3 ,2 / // 1 - >3 5
					D[node] = d + 1;
					q.offer(new Pair6118(node, D[node]));
				}
			}
		}
	}
}
