import java.util.*;
import java.io.*;

public class Baek1062 {
	public static boolean[] visited;
	static HashMap<Character, Integer> hsmap = new HashMap<>();
	static int max = 0;
	static HashSet<Integer> hsset = new HashSet<>();
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int sum2 = 0;

		for (int i = 0; i < N; i++) {
			String X = br.readLine();
			int sum = 0;
			visited = new boolean[26];
			for (int j = 0; j < X.length(); j++) {
				char c = X.charAt(j);
				if (visited[c - 'a'])
					continue;
				visited[c - 'a'] = true;
				sum |= 1 << c - 'a';
				if (c == 'a' || c == 'n' || c == 't' || c == 'i' || c == 'c') {
					sum2 |= 1 << c - 'a';
					continue;
				}
			}
			arr[i] = sum;
		}
		if (M < 5 || M >= 26) {
			System.out.println(M == 26 ? N : "0");
			return;
		}
		dfs(0, 5, sum2);
		for (int x : hsset) {
			int cnt = 0;
			for (int c : arr) {
				if ((x & c) == c) {
					cnt++;
				}
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);
		br.close();
	}

	public static void dfs(int start, int cnt, int sum) {
		if (cnt == M) {
			hsset.add(sum);
			return;
		}

		for (int i = start; i < 26; i++) {
			if ((sum & 1 << i) == 0) {
				dfs(i + 1, cnt + 1, sum | 1 << i);
			}
		}

	}
}
