import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek5014 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[F + 1];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { S, 0 });
		visited[S] = true;
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int cur = p[0];
			int cnt = p[1];
			if (cur == G) {
				System.out.println(cnt);
				return;
			}
			int up = cur + U;
			int down = cur - D;
			if (up <= F && !visited[up]) {
				visited[up] = true;
				q.offer(new int[] { up, cnt + 1 });
			}
			if (down > 0 && !visited[down]) {
				visited[down] = true;
				q.offer(new int[] { down, cnt + 1 });
			}
		}
		System.out.println("use the stairs");
	}
}
