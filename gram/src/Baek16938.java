import java.util.*;
import java.io.*;

public class Baek16938 {
	static int N, L, R, X;
	static int[] problem_set;
	static boolean[] visited;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		visited = new boolean[N];
		problem_set = new int[N];
		for (int i = 0; i < N; i++) {
			problem_set[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0, 0, 1987654320, 0);
		System.out.println(answer);
	}

	public static void dfs(int depth, int start, int sum, int min, int max) {
		if (depth <= N && depth > 1) {
			if (sum >= L && sum <= R && max - min >= X)
				answer++;
			if (depth == N)
				return;
		}
		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(depth + 1, i, sum + problem_set[i], min > problem_set[i] ? problem_set[i] : min,
						max < problem_set[i] ? problem_set[i] : max);
				visited[i] = false;
			}
		}
	}

}
