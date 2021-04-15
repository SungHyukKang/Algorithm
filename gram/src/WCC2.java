import java.util.*;

public class WCC2 {
	public static int solution(String s) {
		int answer = 0;
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			sb.append(s.substring(1) + s.charAt(0));
			s = sb.toString();
			boolean tf = true;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == ']') {
					if (stack.isEmpty()) {
						tf = false;
						break;
					}
					char x = stack.pop();
					if (x != '[') {
						tf = false;
						break;
					}
				} else if (s.charAt(j) == '}') {
					if (stack.isEmpty()) {
						tf = false;
						break;
					}

					char x = stack.pop();
					if (x != '{') {
						tf = false;
						break;
					}
				} else if (s.charAt(j) == ')') {
					if (stack.isEmpty()) {
						tf = false;
						break;
					}

					char x = stack.pop();
					if (x != '(') {
						tf = false;
						break;
					}
				} else {
					stack.push(s.charAt(j));
				}
			}
			if (tf) {
				answer++;
			}
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		solution("(");
	}

}
