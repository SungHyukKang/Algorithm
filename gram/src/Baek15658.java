import java.util.*;
import java.io.*;

class Pair15658 {
	int idx;
	char op;
	int prior;

	public Pair15658(int idx, char op, int prior) {
		this.idx = idx;
		this.op = op;
		this.prior = prior;
	}

	@Override
	public String toString() {
		return op + " ";
	}

}

public class Baek15658 {
	static int N;
	static int[] arr;
	static Stack<Pair15658> stack = new Stack<>();
	static int max = 0;
	static int min = 2100000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int mul = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());
		dfs(0, plus, minus, mul, div);
		System.out.println(max + "\n" + min);
	}

	public static void dfs(int depth, int plus, int minus, int mul, int div) {
		if (depth == N - 1) {
//			for (Pair15658 p : stack)
//				list.add(p);
//			Collections.sort(list, new Comparator<Pair15658>() {
//				@Override
//				public int compare(Pair15658 arg0, Pair15658 arg1) {
//					if (arg0.prior < arg1.prior) {
//						return 1;
//					} else if (arg0.prior == arg1.prior) {
//						return Integer.compare(arg0.idx, arg1.idx);
//					}
//					return -1;
//				}
//			});
			int sum = arr[stack.get(0).idx];
			for (Pair15658 p : stack) {
				char c = p.op;
				int idx = p.idx;
				if (c == '+') {
					sum += arr[idx + 1];
				} else if (c == '-') {
					sum -= arr[idx + 1];
				} else if (c == '*') {
					sum *= arr[idx + 1];
				} else {
					sum /= arr[idx + 1];
				}
			}
			if (max < sum) {
				max = sum;

			}
			if (min > sum) {
				min = sum;
			}
			return;
		}
		if (plus > 0) {
			stack.push(new Pair15658(depth, '+', 0));
			dfs(depth + 1, plus - 1, minus, mul, div);
			stack.pop();
		}
		if (minus > 0) {

			stack.push(new Pair15658(depth, '-', 0));
			dfs(depth + 1, plus, minus - 1, mul, div);
			stack.pop();
		}
		if (mul > 0) {

			stack.push(new Pair15658(depth, '*', 1));
			dfs(depth + 1, plus, minus, mul - 1, div);
			stack.pop();
		}
		if (div > 0) {

			stack.push(new Pair15658(depth, '/', 1));
			dfs(depth + 1, plus, minus, mul, div - 1);
			stack.pop();
		}
	}
}
