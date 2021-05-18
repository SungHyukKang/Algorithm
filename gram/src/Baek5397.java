import java.util.*;
import java.io.*;

public class Baek5397 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			char[] pw = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			Stack<Character> stack2 = new Stack<>();
			for (int i = 0; i < pw.length; i++) {
				if (pw[i] == '<') {
					if (stack.isEmpty()) {
						continue;
					}
					stack2.push(stack.pop());
				} else if (pw[i] == '>') {
					if (stack2.isEmpty()) {
						continue;
					}
					stack.push(stack2.pop());
				} else if (pw[i] == '-') {
					if (stack.isEmpty())
						continue;
					stack.pop();
				} else {
					stack.push(pw[i]);
				}
			}
			while (!stack2.isEmpty())
				stack.push(stack2.pop());
			for (char x : stack) {
				sb.append(x);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
