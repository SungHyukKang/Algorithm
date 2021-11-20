import java.util.*;
import java.io.*;

public class Baek16508 {

	static class data {
		int[] str;
		int cost;

		public data(String str, int cost) {
			this.str = new int[26];
			for (int i = 0; i < str.length(); i++) {
				this.str[str.charAt(i) - 'A']++;
			}
			this.cost = cost;
		}
	}

	static int[] target = new int[26];
	static data[] datas;
	static int[] visited = new int[26];
	static int N;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			target[s.charAt(i) - 'A']++;
		}

		N = Integer.parseInt(br.readLine());
		datas = new data[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			datas[i] = new data(str, cost);
		}
		dfs(0, 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	public static void dfs(int index, int sum) {
		if (index == N) {
			for (int i = 0; i < 26; i++) {
				if (target[i] > visited[i]) {
					return;
				}
			}
			answer = Math.min(answer, sum);
			return;
		}

		for (int i = 0; i < 26; i++)
			visited[i] += datas[index].str[i];
		dfs(index + 1, sum + datas[index].cost);
		for (int i = 0; i < 26; i++)
			visited[i] -= datas[index].str[i];
		dfs(index + 1, sum);

	}
}