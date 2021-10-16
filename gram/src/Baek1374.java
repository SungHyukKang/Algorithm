import java.util.*;
import java.io.*;

public class Baek1374 {
	static class Data implements Comparable<Data> {
		int id;
		int s;
		int e;

		public Data(int id, int s, int e) {
			this.id = id;
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Data o) {
			if (this.s > o.s) {
				return 1;
			} else if (this.s == o.s) {
				if (this.e > o.e)
					return 1;
			}
			return -1;
		}

		@Override
		public String toString() {
			return "id=" + id + ", s=" + s + ", e=" + e;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Data> pq = new PriorityQueue<>();
		PriorityQueue<Integer> room = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pq.offer(new Data(id, s, e));
		}
		room.offer(pq.poll().e);
		while (!pq.isEmpty()) {
			if (room.peek() <= pq.peek().s) {
				room.offer(pq.poll().e);
				room.poll();
			} else {
				room.offer(pq.poll().e);
			}
		}
		System.out.println(room.size());

	}

}
