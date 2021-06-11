import java.util.*;
import java.io.*;

public class Baek3671 {
	static int[] arr;
	static Stack<Integer> stack;
	static boolean[] visited;
	static HashSet<Integer> hsset = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String num = br.readLine();
			stack = new Stack<>();
			arr = new int[num.length()];
			visited = new boolean[arr.length];
			hsset = new HashSet<>();
			for (int i = 0; i < num.length(); i++) {
				arr[i] = num.charAt(i) - '0';
			}
			dfs(0);
			int cnt = 0;
			for (int x : hsset) {
				if (x == 0 || x == 1) {
					continue;
				}
				cnt++;
				for (int i = 2; i <= Math.sqrt(x); i++) {
					if (x % i == 0) {
						cnt--;
						break;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void dfs(int idx) {
		if (idx == arr.length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
			int num = Integer.parseInt(sb.toString());
			if (hsset.contains(num)) {
				return;
			}
			sb = new StringBuilder();
			for (int i = 0; i < stack.size(); i++) {
				hsset.add(stack.get(i));
				sb.append(stack.get(i));
				hsset.add(Integer.parseInt(sb.toString()));
			}
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				stack.push(arr[i]);
				dfs(idx + 1);
				stack.pop();
				visited[i] = false;
			}
		}
	}

}
