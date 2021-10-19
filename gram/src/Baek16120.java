import java.util.*;
import java.io.*;

public class Baek16120 {

	public static void main(String[] args) throws IOException {
		char[] ch = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		if (ch[ch.length - 1] == 'A') {
			System.out.println("NP");
			return;
		}
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 'P') {
				stack.push(ch[i]);
			} else {
				if (ch[i + 1] == 'P' && stack.size() >= 2) {
					stack.pop();
					i += 1;
				} else {
					System.out.println("NP");
					return;
				}
			}
		}
		System.out.println(stack.size() == 1 ? "PPAP" : "NP");
	}

}
