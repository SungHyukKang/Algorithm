import java.util.*;
import java.io.*;

public class Baek1715 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		int answer = 0;
		if (pq.size() == 1) {
			System.out.println(0);
			return;
		}
		while (!pq.isEmpty()) {
			if (pq.size() == 1) {
				break;
			}
			int num = pq.poll();
			int num2 = pq.poll();
			answer += num + num2;
			pq.offer(num + num2);
		}
		System.out.println(answer);
	}

}
