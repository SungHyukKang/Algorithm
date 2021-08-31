import java.util.*;
import java.io.*;

class Baek17616 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		boolean[][] visited = new boolean[N + 1][2];

		ArrayList<ArrayList<Integer>[]> adjlist = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adjlist.add(new ArrayList[2]);
			adjlist.get(i)[0] = new ArrayList<>();
			adjlist.get(i)[1] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjlist.get(s)[0].add(e);
			adjlist.get(e)[1].add(s);
		}
		int best = 1 + bfs(visited, adjlist, 1, X);
		int worst = N - bfs(visited, adjlist, 0, X);
		System.out.println(best + " " + worst);
	}

	static int bfs(boolean[][] visited, ArrayList<ArrayList<Integer>[]> adjlist, int bestOrWorst, int X) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(X);
		visited[X][bestOrWorst] = true;
		int cnt = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : adjlist.get(cur)[bestOrWorst]) {
				if (!visited[next][bestOrWorst]) {
					visited[next][bestOrWorst] = true;
					q.offer(next);
					cnt++;
				}
			}

		}
		return cnt;
	}
}