import java.util.*;
import java.io.*;

class Node13424 implements Comparable<Node13424> {
	int idx;
	int d;

	public Node13424(int idx, int d) {
		this.idx = idx;
		this.d = d;
	}

	@Override
	public int compareTo(Node13424 o) {
		return this.d >= o.d ? -1 : 1;
	}

}

public class Baek13424 {
	static ArrayList<ArrayList<Node13424>> adjlist;
	static int[][] D;
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			adjlist = new ArrayList<ArrayList<Node13424>>();
			D = new int[N + 1][N + 1];
			for (int i = 0; i <= N; i++) {
				adjlist.add(new ArrayList<>());
				Arrays.fill(D[i], INF);
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				adjlist.get(s).add(new Node13424(e, d));
				adjlist.get(e).add(new Node13424(s, d));
			}

			int K = Integer.parseInt(br.readLine());
			int min = INF;
			int[] arr = new int[K];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				int start = Integer.parseInt(st.nextToken());
				arr[i] = start;
			}
			for (int start : arr)
				dijkstra(start, arr);
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				int answer = 0;
				for (int x : arr) {
					answer += D[x][i];
				}
				if (min > answer) {
					min = answer;
					ans = i;
				}
			}
			sb.append(ans + "\n");

		}
		System.out.println(sb);
	}

	public static void dijkstra(int start, int[] arr) {
		PriorityQueue<Node13424> pq = new PriorityQueue<>();
		pq.offer(new Node13424(start, 0));
		D[start][start] = 0;
		while (!pq.isEmpty()) {
			Node13424 n = pq.poll();
			int idx = n.idx;
			int d = n.d;

			if (d > D[start][idx])
				continue;
			for (Node13424 next : adjlist.get(idx)) {
				if (D[start][next.idx] > next.d + D[start][idx]) {
					D[start][next.idx] = next.d + D[start][idx];
					pq.offer(new Node13424(next.idx, D[start][next.idx]));
				}
			}
		}
	}

}
