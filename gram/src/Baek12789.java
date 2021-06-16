import java.util.*;
import java.io.*;

public class Baek12789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			q.offer(num);
		}
		int need = 1;
		boolean tf = false;
		while (true) {
			if (need == N + 1) {
				tf = true;
				break;
			}
			int qnum = q.isEmpty() ? -1 : q.peek();
			int snum = stack.isEmpty() ? -1 : stack.peek();
			if (qnum == need) {
				q.poll();
				need++;
			} else if (snum == need) {
				stack.pop();
				need++;
			} else {
				stack.push(qnum);
				q.poll();
			}
			if (q.isEmpty() && !stack.isEmpty() && stack.peek() != need) {
				break;
			}
		}
		if (tf) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}
}
