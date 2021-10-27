import java.util.*;
import java.io.*;

public class Baek15903 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}
		for (int i = 0; i < m; i++) {
			long one = pq.poll();
			long two = pq.poll();
			pq.offer(one + two);
			pq.offer(one + two);
		}
		long sum = 0;
		while (!pq.isEmpty()) {
			sum += pq.poll();
		}
		System.out.println(sum);
	}

}
