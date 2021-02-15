import java.util.*;
import java.io.*;

public class Baek9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] st = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		String boom = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < st.length; i++) {
			if (st[i] == boom.charAt(boom.length() - 1)) {
				StringBuilder sb2 = new StringBuilder();
				stack.push(st[i]);
				for (int j = 0; j < boom.length(); j++) {
					if (!stack.isEmpty())
						sb2.append(stack.pop());
				}
				sb2 = sb2.reverse();
				if (!sb2.toString().equals(boom)) {
					for (int j = 0; j < sb2.length(); j++) {
						stack.push(sb2.charAt(j));
					}
				}
				continue;
			}
			stack.push(st[i]);
		}
		for (char c : stack)
			sb.append(c);
		System.out.println(stack.isEmpty() ? "FRULA" : sb.toString());
	}

}
