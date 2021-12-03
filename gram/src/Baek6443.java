import java.io.*;

public class Baek6443 {
	static char[] str;
	static int[] alpha;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			str = br.readLine().toCharArray();
			alpha = new int[26];
			for (int i = 0; i < str.length; i++) {
				alpha[str[i] - 'a']++;
			}
			dfs("", 0);
		}
		System.out.println(sb);
	}

	public static void dfs(String s, int depth) {
		if (depth == str.length) {
			sb.append(s).append("\n");
			return;
		}
		for (int i = 0; i < 26; i++) {
			if (alpha[i] > 0) {
				alpha[i]--;
				dfs(s + (char) ('a' + i), depth + 1);
				alpha[i]++;
			}
		}

	}
}
