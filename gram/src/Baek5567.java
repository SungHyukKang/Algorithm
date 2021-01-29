import java.util.*;
import java.io.*;

class Pair5567 {
	int idx;
	int depth;

	public Pair5567(int idx, int depth) {
		this.idx = idx;
		this.depth = depth;
	}
}

public class Baek5567 {
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}
		bfs();
	}

	public static void bfs() {
		Queue<Pair5567> q = new LinkedList<>();
		q.offer(new Pair5567(1, 0));
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		int cnt=0;
		while (!q.isEmpty()) {
			Pair5567 p = q.poll();
			int idx=p.idx;
			int d=p.depth;
			if(d>2)
				continue;
			System.out.println(idx +  " " +d);
			cnt++;
			for(int x : list.get(idx)) {
				if(!visited[x]) {
					q.offer(new Pair5567(x,d+1));
					visited[x]=true;
				}
			}
		}
		System.out.println(cnt-1);
	}
}
