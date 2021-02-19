import java.io.*;
import java.util.*;

class Pair12852 {
	int n;
	int cnt;
	StringBuilder sb;

	public Pair12852(int n, int cnt, StringBuilder sb) {
		this.n = n;
		this.cnt = cnt;
		this.sb = sb;
		sb.append(n + " ");
	}
}

public class Baek12852 {
	static Queue<Pair12852> q = new LinkedList<>();
	static boolean[] visited = new boolean[1000001];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		q.offer(new Pair12852(N, 0, new StringBuilder()));
		visited[N] = true;
		bfs();
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs() throws IOException {

		while (!q.isEmpty()) {
			Pair12852 p = q.poll();
			int num = p.n;
			int cnt = p.cnt;
			StringBuilder sb = p.sb;
			if (num == 1) {
				bw.write(cnt + "\n");
				bw.write(sb.toString());
				break;
			}

			if (num % 3 == 0 && !visited[num / 3]) {
				q.offer(new Pair12852(num / 3, cnt + 1, new StringBuilder(sb.toString())));
				visited[num / 3] = true;
			}
			if (num % 2 == 0 && !visited[num / 2]) {
				q.offer(new Pair12852(num / 2, cnt + 1, new StringBuilder(sb.toString())));
				visited[num / 2] = true;
			}
			if (!visited[num - 1]) {
				q.offer(new Pair12852(num - 1, cnt + 1, new StringBuilder(sb.toString())));
				visited[num - 1] = true;
			}

		}

	}

}
