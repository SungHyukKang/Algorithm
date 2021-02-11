import java.util.*;
import java.io.*;

public class Baek1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String X = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		HashMap<Character, Integer> hsmap = new HashMap<>();
		hsmap.put('*', 1);
		hsmap.put('/', 1);
		hsmap.put('-', 0);
		hsmap.put('+', 0);
		for (int i = 0; i < X.length(); i++) {
			char c = X.charAt(i);
			if ((int) c >= 65) {
				sb.append(c);
			} else {
				if (c == '(') {
					stack.push(c);
				} else if (c == ')') {
					while (true) {
						char x = stack.pop();
						if (x == '(')
							break;
						sb.append(x);
					}
				} else {
					switch (c) {
					case '*':
					case '/':
						while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
							sb.append(stack.pop());
						}
						stack.push(c);
						break;
					case '+':
					case '-':
						while (!stack.isEmpty() && stack.peek() != '(') {
							sb.append(stack.pop());
						}
						stack.push(c);
						break;
					}
				}
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}

}
