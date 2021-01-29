package KAKAO2020InternShip;

import java.util.*;

public class 수식최대화 {
	static String[] op = new String[] { "-", "+", "*" };
	static Stack<String> prior = new Stack<>();
	static ArrayList<String> operand = new ArrayList<>();
	static ArrayList<String> operator = new ArrayList<>();
	static ArrayList<String> all = new ArrayList<>();
	static boolean[] visited = new boolean[3];
	static long max = 0;

	public static long solution(String expression) {
		for (String X : expression.split("[-+*]")) {
			operand.add(X);
		}
		for (String X : expression.replaceAll("[0-999]", "").split("")) {
			operator.add(X);
		}
		for (int i = 0, x = 0, z = 0; i < operand.size() + operator.size(); i++) {
			if (i % 2 == 0) {
				all.add(operand.get(x++));
			} else {
				all.add(operator.get(z++));
			}
		}
		dfs(0);
		System.out.println(max);
		return max;
	}

	public static void dfs(int cnt) {
		if (cnt == 3) {
			Deque<String> q = new LinkedList<>();
			for (String X : all)
				q.offer(X);
			for (String c : prior) {
				int size = q.size();
				int count = 0;
				while (count != size) {
					String Z = q.poll();
					count++;
					if (Z.equals(c)) {
						long x = Long.parseLong(q.pollLast());
						long y = Long.parseLong(q.poll());
						String d;
						if (Z.equals("+")) {
							d = String.valueOf((x + y));
							q.add(d);
						} else if (Z.equals("*")) {
							d = String.valueOf((x * y));
							q.add(d);
						} else {
							d = String.valueOf((x - y));
							q.add(d);
						}
						count++;
					} else {
						q.add(Z);
					}
				}
			}
			long num = Math.abs(Long.parseLong(q.poll()));
			if (num > max) {
				max = num;
			}
			return;
		}
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				prior.push(op[i]);
				dfs(cnt + 1);
				prior.pop();
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		solution("999*999*999*999");
	}

}
