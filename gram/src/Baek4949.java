import java.util.*;
import java.io.*;

public class Baek4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String X;
		while (!(X = br.readLine()).equals(".")) {
			Stack<Character> stack = new Stack<>();
			boolean tf = true;
			for (int i = 0; i < X.length(); i++) {
				char c = X.charAt(i);
				if (c == ')') {
					if (stack.isEmpty()) {
						tf = false;
					} else {
						char x = stack.pop();
						if (x != '(') {
							tf = false;
						}
					}
				} else if (c == ']') {
					if (stack.isEmpty()) {
						tf = false;
					} else {
						char x = stack.pop();
						if (x != '[') {
							tf = false;
						}
					}
				} else if (c == '(' || c == '[') {
					stack.push(c);
				}
			}
			System.out.println(tf&&stack.isEmpty() ? "yes" : "no");
		}
	}

}
