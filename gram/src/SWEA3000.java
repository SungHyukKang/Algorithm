import java.util.*;
import java.io.*;

public class SWEA3000 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		final int moduler = 20171109;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int init = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minheap = new PriorityQueue<>();
			maxheap.add(init);
			int sum = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					int a = Integer.parseInt(st.nextToken());
					int mid = maxheap.peek();
					if (maxheap.size() > minheap.size()) {
						if (mid > a) {
							minheap.offer(maxheap.poll());
							maxheap.offer(a);
						} else {
							minheap.offer(a);
						}
					} else if (maxheap.size() == minheap.size()) {
						if (a > mid) {
							minheap.offer(a);
							maxheap.offer(minheap.poll());
						} else {
							maxheap.offer(a);
						}
					} else {
						maxheap.offer(a);
					}
				}
				sum += maxheap.peek() % moduler;
				sum %= moduler;
			}
			sb.append("#" + t + " " + sum + "\n");
		}
		System.out.println(sb);
	}

}
