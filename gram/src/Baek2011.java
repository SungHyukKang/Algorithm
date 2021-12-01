import java.io.*;
import java.util.*;

public class Baek2011 {
	static char[] ch;
	static int[] dp = new int[5001];

	public static void main(String[] args) throws IOException {
		String str = (new BufferedReader(new InputStreamReader(System.in)).readLine());
		if (str.startsWith("0")) {
			System.out.println(0);
			return;
		}
		if (str.equals("")) {
			System.out.println(0);
			return;
		}
		int idx = 0;
		boolean tf = true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '0') {
				tf = false;
				break;
			}
			idx++;
		}
		if (tf) {
			System.out.println(0);
			return;
		}
		ch = str.substring(idx).toString().toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] < '0' || ch[i] > '9') {
				System.out.println(0);
				return;
			}
		}

		Arrays.fill(dp, -1);
		System.out.println(dfs(0));
	}

	public static int dfs(int depth) {
		if (depth > ch.length)
			return 0;
		if (depth == ch.length) {
			return 1;
		}
		if (ch[depth] == '0') {
			return 0;
		}

		if (dp[depth] != -1)
			return dp[depth] % 1000000;
		dp[depth] = 0;
		if (depth < ch.length - 1) {
			String str = String.valueOf(ch[depth]) + String.valueOf(ch[depth + 1]);
			int num = Integer.parseInt(str);
			if (num <= 26) {
				dp[depth] = (dp[depth] + dfs(depth + 2)) % 1000000;
			}
		}
		dp[depth] = (dp[depth] + dfs(depth + 1)) % 1000000;

		return dp[depth] % 1000000;
	}

}
