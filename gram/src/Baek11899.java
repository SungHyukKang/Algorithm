import java.util.*;
import java.io.*;

public class Baek11899 {

	public static void main(String[] args) throws IOException {
		char[] str = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '(') {
				stack.push('(');
			} else {
				if (stack.isEmpty()) {
					answer++;
					continue;
				}
				if (stack.peek() == '(') {
					stack.pop();
				}
			}
		}
		answer+=stack.size();
		System.out.println(answer);
	}

}
