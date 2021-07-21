import java.util.*;
import java.io.*;

class Pair18513 {
	int saem;
	long next;

	public Pair18513(int saem, long next) {
		this.saem = saem;
		this.next = next;
	}

}

public class Baek18513 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Pair18513> q = new LinkedList<>();
		HashSet<Integer> hsset = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			hsset.add(num);
			q.offer(new Pair18513(num, 0));
		}
		long answer = 0;
		while (!q.isEmpty()) {
			Pair18513 p = q.poll();
			int saem = p.saem;
			long next = p.next + 1;

				if (!hsset.contains(saem - 1)) {
					q.offer(new Pair18513(saem - 1, next));
					answer += next;
					hsset.add(saem - 1);
					K--;
				}
			if (K == 0)
				break;
				if (!hsset.contains(saem + 1)) {
					q.offer(new Pair18513(saem + 1, next));
					answer += next;
					hsset.add(saem + 1);
					K--;
				}
			if (K == 0)
				break;
		}
		System.out.println(answer);
	}

}
