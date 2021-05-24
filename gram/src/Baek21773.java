import java.util.*;
import java.io.*;

class Process21773 implements Comparable<Process21773> {
	int idx, t, prior;

	public Process21773(int idx, int t, int prior) {
		this.idx = idx;
		this.t = t;
		this.prior = prior;
	}

	@Override
	public int compareTo(Process21773 arg0) {
		if (this.prior < arg0.prior) {
			return 1;
		} else if (this.prior == arg0.prior) {
			if (this.idx > arg0.idx) {
				return 1;
			}
		}
		return -1;
	}

}

public class Baek21773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Process21773> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int prior = Integer.parseInt(st.nextToken());
			pq.add(new Process21773(idx, t, prior));
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			if (T == 0)
				break;
			Process21773 p = pq.poll();
			int idx = p.idx;
			int prior = p.prior;
			int t = p.t;
			if (t - 1 > 0) {
				pq.offer(new Process21773(idx, t - 1, prior - 1));
			}
			sb.append(idx + "\n");
			T--;
		}
		System.out.print(sb);
	}

}
