import java.util.*;
import java.io.*;

public class Baek16198 {
	static int[] arr;
	static boolean[] visited;
	static int N;
	static int max = 0;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);
		System.out.println(max);
	}

	public static void dfs(int depth, int gob) {
		if (depth == N - 2) {
			if (max < gob) {
				max = gob;
			}
			return;
		}

		for (int i = 1; i < N - 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int temp1 = 0;
				int temp2 = 0;
				for (int j = i; j >= 0; j--) {
					if (!visited[j]) {
						temp1 = arr[j];
						break;
					}
				}
				for (int j = i; j < N; j++) {
					if (!visited[j]) {
						temp2 = arr[j];
						break;
					}
				}
				dfs(depth + 1, gob + temp1 * temp2);
				visited[i] = false;
			}
		}
	}

}
