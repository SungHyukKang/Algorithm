import java.util.*;
import java.io.*;

class Pair11286 implements Comparable<Pair11286> {
	int x;
	int absX;

	public Pair11286(int x) {
		this.x = x;
		this.absX = Math.abs(x);
	}

	@Override
	public int compareTo(Pair11286 o) {
		if (absX < o.absX) {
			return -1;
		} else if (absX == o.absX) {
			return x <= o.x ? -1 : 1;
		}
		return 1;
	}

}

public class Baek11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Pair11286> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int d = Integer.parseInt(br.readLine());
			if (d == 0) {
				if (pq.isEmpty()) {
					bw.write("0\n");
					continue;
				}
				bw.write(pq.poll().x + "\n");
			} else
				pq.offer(new Pair11286(d));
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
