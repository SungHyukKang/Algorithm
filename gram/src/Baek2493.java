import java.util.*;
import java.io.*;

class Pair2493 {
	int idx;
	int num;

	public Pair2493(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Pair2493 [idx=" + idx + ", num=" + num + "]";
	}

}

public class Baek2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		arr[0] = 0;
		Stack<Pair2493> stack = new Stack<>();
		for (int i = 1; i <= N; i++) {
			int X = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				Pair2493 CC = stack.peek();
				int C = CC.num;
				if (X < C) {
					bw.write(stack.peek().idx + " ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty())
				bw.write("0 ");
			stack.push(new Pair2493(i, X));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
