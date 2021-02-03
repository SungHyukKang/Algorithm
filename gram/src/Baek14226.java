import java.util.*;
import java.io.*;

class Pair14226 {
	int d;
	int cnt;
	int clip;

	public Pair14226(int d, int cnt, int clip) {
		this.d = d;
		this.cnt = cnt;
		this.clip = clip;
	}

	@Override
	public String toString() {
		return "@d=" + d + ", cnt=" + cnt + ", clip=" + clip;
	}

}

public class Baek14226 {
	static int target;
	static Queue<Pair14226> q = new LinkedList<>();
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		visited = new boolean[10000][1001];
		q.offer(new Pair14226(1, 0, 0));
		bfs();
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Pair14226 p = q.poll();
			int d = p.d;
			int cnt = p.cnt;
			int clip = p.clip;
			if (clip > target)
				continue;
			if (d == target) {
				System.out.println(cnt);
				break;
			}
			if (d <= target && !visited[d][d]) {
				q.offer(new Pair14226(d, cnt + 1, d));
				visited[d][d] = true;
			}
			if ((d + clip) <= target && !visited[d + clip][clip]) {
				q.offer(new Pair14226(d + clip, cnt + 1, clip));
				visited[d + clip][clip] = true;
			}
			if (d - 1 > 0 && !visited[d - 1][clip]) {
				q.offer(new Pair14226(d - 1, cnt + 1, clip));
				visited[d - 1][clip] = true;
			}
		}
	}
}
