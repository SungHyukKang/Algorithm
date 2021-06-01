import java.util.*;

public class 야근_지수 {
	public static long solution(int n, int[] works) {
		long answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < works.length; i++) {
			pq.offer(works[i]);
		}
		for (int i = 0; i < n; i++) {
			int num = pq.poll() - 1;
			if (num < 0)
				break;
			pq.offer(num);
		}
		while (!pq.isEmpty()) {
			int num = pq.poll();
			answer += num * num;
		}
		return answer;
	}

	public static void main(String[] args) {
		solution(4, new int[] { 4, 3, 3 });
	}

}
