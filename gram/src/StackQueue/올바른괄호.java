package StackQueue;

import java.util.*;

public class 올바른괄호 {
	static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			if (x == '(') {
				stack.push(x);
			} else {
				if (stack.isEmpty())
					return false;
				stack.pop();
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(solution("()()"));
	}

}
