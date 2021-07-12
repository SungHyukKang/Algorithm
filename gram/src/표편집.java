import java.util.*;

public class 표편집 {

	public static String solution(int n, int k, String[] cmd) {
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min = new PriorityQueue<>();
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i <= k; i++)
			max.offer(i);
		for (int i = k + 1; i < n; i++)
			min.offer(i);
		for (String commands : cmd) {
			String[] c = commands.split(" ");
			String command;
			int step = 0;
			if (c.length == 2) {
				command = c[0];
				step = Integer.parseInt(c[1]);
			} else
				command = c[0];

			if (command.equals("D")) {
				for (int i = 0; i < step; i++) {
					max.offer(min.poll());
				}
			} else if (command.equals("U")) {
				for (int i = 0; i < step; i++) {
					min.offer(max.poll());
				}
			} else if (command.equals("C")) {
				dq.offer(max.poll());
				if (!min.isEmpty()) {
					max.offer(min.poll());
				}
			} else {
				int Z = dq.pollLast();
				if (max.peek() < Z) {
					min.offer(Z);
				} else
					max.offer(Z);
			}
		}
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add("O");
		}
		while (!dq.isEmpty()) {
			arr.set(dq.poll(), "X");
		}
		StringBuilder sb = new StringBuilder();
		for (String Z : arr)
			sb.append(Z);
		return sb.toString();
	}

	public static void main(String[] args) {
		solution(8, 2, new String[] { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" });
	}

}
