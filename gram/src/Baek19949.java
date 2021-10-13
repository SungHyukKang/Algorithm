import java.util.*;
import java.io.*;

public class Baek19949 {
	static int[] answer;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer = new int[10];
		for (int i = 0; i < 10; i++)
			answer[i] = Integer.parseInt(st.nextToken());
		dfs(0, -1, 0, 0);
		System.out.println(sum);
	}

	public static void dfs(int cnt, int pre, int ans, int depth) {
		if (depth - ans > 5)
			return;
		if (depth == 10) {
			if (ans >= 5)
				sum++;
			return;
		}
		for (int i = 1; i <= 5; i++) {// cnt = 2 , pre = i => continue
			if (cnt >= 2 && pre == i)
				continue;
			if (answer[depth] == i) {
				if (pre == i) {
					dfs(cnt + 1, i, ans + 1, depth + 1);
				} else {
					dfs(1, i, ans + 1, depth + 1);
				}
			} else {
				if (pre == i) {
					dfs(cnt + 1, i, ans, depth + 1);
				} else {
					dfs(1, i, ans, depth + 1);
				}
			}
		}

	}

}
