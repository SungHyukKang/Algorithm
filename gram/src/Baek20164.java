import java.util.*;
import java.io.*;

public class Baek20164 {
	static String N;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		N = new BufferedReader(new InputStreamReader(System.in)).readLine();
		dfs(N, 0);
		System.out.println(min + " " + max);
	}

	public static void dfs(String str, int sum) {
		if (str.length() == 1) {
			min = Math.min(min, ((str.charAt(0) - '0') & 1) == 1 ? sum + 1 : sum);
			max = Math.max(max, ((str.charAt(0) - '0') & 1) == 1 ? sum + 1 : sum);
			return;
		}
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (((str.charAt(i) - '0') & 1) == 1) {
				cnt++;
			}
		}
		if (str.length() >= 3) {
			for (int i = 0; i < str.length(); i++) {
				for (int j2 = i + 2; j2 < str.length(); j2++) {
					int a1 = Integer.parseInt(str.substring(0, i + 1));
					int a2 = Integer.parseInt(str.substring(i + 1, j2));
					int a3 = Integer.parseInt(str.substring(j2));
					int summary = a1 + a2 + a3;
					dfs(String.valueOf(summary), sum + cnt);
				}
			}

		} else if (str.length() == 2) {
			int a1 = str.charAt(0) - '0';
			int a2 = str.charAt(1) - '0';
			dfs(String.valueOf(a1 + a2), sum + cnt);
		}

	}

}
