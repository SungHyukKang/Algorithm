import java.util.*;
import java.io.*;

public class Baek17255 {
	static int N;
	static int size;
	static HashMap<Integer, Integer> hsmap = new HashMap<>();
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		String Z = String.valueOf(N);
		size = Z.length();
		for (int i = 0; i < Z.length(); i++) {
			int x = Z.charAt(i) - '0';
			hsmap.put(x, hsmap.getOrDefault(x, 0) + 1);
		}
		dfs(0, "");
		System.out.println(answer);
	}

	public static void dfs(int depth, String Z) {
		if (depth == size) {
			if (Integer.parseInt(Z) == N) {
				answer++;
			}
			return;
		}
		for (int x : hsmap.keySet()) {
			if (hsmap.get(x) > 0) {
				hsmap.put(x, hsmap.get(x) - 1);
				String cpy1 = Z + x;
				String cpy2 = x + Z;
				if (cpy1.equals(cpy2)) {
					dfs(depth + 1, cpy1);
				} else {
					dfs(depth + 1, cpy1);
					dfs(depth + 1, cpy2);
				}
				hsmap.put(x, hsmap.get(x) + 1);
			}
		}

	}

}
