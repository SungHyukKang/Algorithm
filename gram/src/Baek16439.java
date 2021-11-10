import java.util.*;
import java.io.*;

public class Baek16439 {
	static Stack<Integer> stack = new Stack<>();
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] visited = new boolean[M];
		dfs(N, M, arr, visited, 0);
		System.out.println(max);
	}

	public static void dfs(int N, int M, int[][] arr, boolean[] visited, int depth) {
		if (depth == 3) {
			int answer = 0;
			for (int i = 0; i < N; i++) {
				int mmax = 0;
				for (int chick : stack) {
					mmax = Math.max(mmax, arr[i][chick]);
				}
				answer += mmax;
			}
			max = Math.max(max, answer);
			return;
		}

		for (int i = 0; i < M; i++) {
			if (!visited[i]) {
				visited[i] = true;
				stack.push(i);
				dfs(N, M, arr, visited, depth + 1);
				stack.pop();
				visited[i] = false;
			}
		}

	}

}
