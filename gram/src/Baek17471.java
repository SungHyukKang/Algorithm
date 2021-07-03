import java.util.*;
import java.io.*;

public class Baek17471 {
	static int N;
	static int[] ingu;
	static ArrayList<ArrayList<Integer>> adjlist;
	static boolean[] visited;
	static Stack<Integer> stack = new Stack<>();
	static int total;
	static int answer = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ingu = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			ingu[i] = Integer.parseInt(st.nextToken());
			total += ingu[i];
		}
		adjlist = new ArrayList<>();
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			adjlist.add(new ArrayList<>());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int leng = Integer.parseInt(st.nextToken());
			for(int j =0;j<leng;j++) {
				int e = Integer.parseInt(st.nextToken());
				adjlist.get(i).add(e);
			}
		}

	dfs(0, 1);
		System.out.println(answer == 987654321 ? -1 : answer);
	}

	public static void dfs(int depth, int idx) {
		if (depth == N)
			return;
		if (stack.size() > 0) {
			boolean[] visit = new boolean[N + 1];
			Queue<Integer> q = new LinkedList<>();
			q.offer(stack.get(0));
			Arrays.fill(visit, true);
			for (int x : stack) {
				visit[x] = false;
			}
			visit[stack.get(0)] = true;
			while (!q.isEmpty()) {
				int index = q.poll();
				for (int next : adjlist.get(index)) {
					if (!visit[next]) {
						q.offer(next);
						visit[next] = true;
					}
				}
			}
			boolean tf = true;
			int sum = 0;
			for (int x : stack) {
				if (!visit[x]) {
					tf = false;
					break;
				}
				sum += ingu[x];
			}
			Arrays.fill(visit, false);
			for (int x : stack) {
				visit[x] = true;
			}
			q = new LinkedList<>();
			for (int i = 1; i <= N; i++) {
				if (!visit[i]) {
					q.offer(i);
					visit[i] = true;
					while (!q.isEmpty()) {
						int x = q.poll();
						for (int next : adjlist.get(x)) {
							if (!visit[next]) {
								visit[next] = true;
								q.offer(next);
							}
						}
					}
					break;
				}
			}
			boolean tf2 = true;
			for (int i = 1; i <= N; i++) {
				if (!visit[i]) {
					tf2 = false;
					break;
				}
			}
			if (tf && tf2) {
				int chai = Math.abs(total - sum - sum);
				if (chai < answer) {
					answer = chai;
				}
			}
		}
		for (int i = idx; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				stack.push(i);
				dfs(depth + 1, i + 1);
				stack.pop();
				visited[i] = false;
			}
		}
	}

}
