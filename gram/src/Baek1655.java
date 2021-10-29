import java.util.*;
import java.io.*;

public class Baek1655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		maxHeap.offer(Integer.parseInt(br.readLine()));
		sb.append(maxHeap.peek()).append("\n");
		for (int i = 2; i <= N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (maxHeap.size() > minHeap.size()) {
				if (num < maxHeap.peek()) {
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(num);
				} else
					minHeap.offer(num);
			} else if (maxHeap.size() == minHeap.size()) {
				if (num > maxHeap.peek()) {
					minHeap.offer(num);
					maxHeap.offer(minHeap.poll());
				} else {
					maxHeap.offer(num);
				}
			} else
				maxHeap.offer(num);
			sb.append(maxHeap.peek()).append("\n");
		}
		System.out.println(sb);

	}

}
