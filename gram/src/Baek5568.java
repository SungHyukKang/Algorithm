import java.io.*;
import java.util.*;

public class Baek5568 {
	static HashSet<Integer> hsset = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String num = br.readLine();
			list.add(num);
		}
		boolean[] visited = new boolean[N];
		dfs(0, list, visited, K, "");
		System.out.println(hsset.size());
	}

	public static void dfs(int depth, ArrayList<String> list, boolean[] visited, int k, String str) {
		if (depth == k) {
			hsset.add(Integer.parseInt(str));
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(depth + 1, list, visited, k, str + list.get(i));
				visited[i] = false;
			}
		}

	}

}
