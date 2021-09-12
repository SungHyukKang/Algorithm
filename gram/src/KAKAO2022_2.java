import java.util.*;

public class KAKAO2022_2 {

	public static int solution(int n, int k) {
		StringBuilder sb = new StringBuilder();
		sb.append(0);
		int num = n;
		while (true) {
			if (num == 0)
				break;
			sb.append(num % k);
			num /= k;
		}

		char[] arr = sb.reverse().toString().toCharArray();
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int cToi = arr[i] - '0';
			if (cToi != 0) {
				stack.push(cToi);
			} else {
				if (stack.isEmpty())
					continue;
				sb = new StringBuilder();
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				long number = Integer.parseInt(sb.reverse().toString());
				if (number == 1)
					continue;
				boolean tf = true;
				for (long idx = 2; idx * idx <= number; idx++) {
					if (number % idx == 0) {
						tf = false;
						break;
					}
				}
				if (tf) {
					count++;
				}

			}
		}
		return count;
	}

	public static void main(String[] args) {
		solution(437674, 3);
	}

}
