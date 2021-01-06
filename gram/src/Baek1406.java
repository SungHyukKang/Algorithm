import java.util.*;
import java.io.*;

public class Baek1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> right = new Stack<>();
		Stack<Character> left = new Stack<>();
		String origin = br.readLine();
		for (int i = 0; i < origin.length(); i++)
			left.push(origin.charAt(i));
		int x = Integer.parseInt(br.readLine());

		for (int i = 0; i < x; i++) {
			String key = br.readLine();
			if (key.startsWith("L")) {
				if (!left.isEmpty())
					right.push(left.pop());
			} else if (key.startsWith("D")) {
				if (!right.isEmpty())
					left.push(right.pop());
			} else if (key.startsWith("B")) {
				if(!left.isEmpty())
					left.pop();
			} else {
				char word = (char) key.split(" ")[1].charAt(0);
				left.push(word);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!right.isEmpty()) {
			left.push(right.pop());
		}
		while(!left.isEmpty()) {
			sb.append(left.pop());
		}
		System.out.println(sb.reverse());
	}
}
