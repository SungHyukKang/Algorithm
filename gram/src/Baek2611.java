import java.util.*;
import java.io.*;

public class Baek2611 {
	static int N;
	static int M;
	static int[] D;
	static int[] result;
	static int[] path;
	public static ArrayList<ArrayList<int[]>> adjlist = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i <= N; i++) {
			adjlist.add(new ArrayList<>());
		}

		D = new int[N + 1];
		result = new int[N + 1];
		path = new int[N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			adjlist.get(p).add(new int[] { q, r });
			D[q]++;
		}
		if (M == 0) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		topologySort();
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		System.out.println(result[1]);
		sb.append("1 ");
		for (int start = path[1]; start != 1; start = path[start]) {
			stack.push(start);
		}
		while (!stack.isEmpty())
			sb.append(stack.pop() + " ");
		sb.append("1");
		System.out.print(sb);
	}

	public static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);

		for (int i = 1; i <= N; i++) {
			if (q.isEmpty()) {
				break;
			}
			int n = q.poll();
			for (int[] nextArr : adjlist.get(n)) {
				int next = nextArr[0];
				int d = nextArr[1];
				if (result[next] < result[n] + d) {
					result[next] = result[n] + d;
					path[next] = n;
				}
				D[next]--;
				if (D[next] == 0) {
					q.offer(next);
				}
			}

		}

	}

}
