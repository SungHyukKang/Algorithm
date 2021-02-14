import java.util.*;
import java.io.*;

public class Baek1107 {
	static int size;
	static int t;
	static boolean[] visited;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String target = br.readLine();
		size = target.length();
		t = Integer.parseInt(target);
		int broken = Integer.parseInt(br.readLine());
		visited = new boolean[10];
		if (broken > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < broken; i++) {
				int x = Integer.parseInt(st.nextToken());
				visited[x] = true;
			}
		}
		min = Math.abs(100 - t);
		for (int i = 1; i <= target.length() + 1; i++) {
			size = i;
			dfs(0, "");
		}
		System.out.println(min);
	}

	public static void dfs(int depth, String val) {
		if (depth == size && !val.equals("")) {
			int ta = Integer.parseInt(val);
			if (min > Math.abs(t - ta) + depth) {
				min = Math.abs(t - ta) + depth;
			}
			return;
		}
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				dfs(depth + 1, val + i);
			}
		}
	}
}