import java.util.*;
import java.io.*;

public class Baek1208 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		HashMap<Integer, Long> hsmap = new HashMap<>();
		HashMap<Integer, Long> hsmap2 = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, N / 2, 0, hsmap);
		dfs(N / 2, N, 0, hsmap2);
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		for (int X : hsmap.keySet()) {
			left.add(X);
		}
		for (int X : hsmap2.keySet()) {
			right.add(X);
		}
		Collections.sort(left);
		Collections.sort(right);
		int left_idx = 0;
		int right_idx = right.size() - 1;
		long answer = 0;
		while (left_idx < left.size() && right_idx >= 0) {
			int left_val = left.get(left_idx);
			int right_val = right.get(right_idx);
			if (left_val + right_val == S) {
				answer += hsmap.get(left_val) * hsmap2.get(right_val);
				left_idx++;
				right_idx--;
			} else if (left_val + right_val < S) {
				left_idx++;
			} else
				right_idx--;
		}
		System.out.println(S == 0 ? answer - 1 : answer);
	}

	public static void dfs(int depth, int target, int sum, HashMap<Integer, Long> hsmap) {
		if (depth == target) {
			hsmap.put(sum, hsmap.getOrDefault(sum, (long) 0) + 1);
			return;
		}
		dfs(depth + 1, target, sum + arr[depth], hsmap);
		dfs(depth + 1, target, sum, hsmap);
	}

	public static void dfs2(int depth, int target, int sum, HashMap<Integer, Long> hsmap) {
		if (depth == target) {
			hsmap.put(sum, hsmap.getOrDefault(sum, (long) 0) + 1);
			return;
		}
		dfs(depth + 1, target, sum + arr[depth], hsmap);
		dfs(depth + 1, target, sum, hsmap);
	}

}
