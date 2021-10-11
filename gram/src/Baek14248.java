import java.util.*;
import java.io.*;

public class Baek14248 {
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] visited = new boolean[N + 1];
		int start = Integer.parseInt(br.readLine());
		dfs(arr, N, visited, start);
		System.out.println(answer);
	}

	public static void dfs(int[] arr, int size, boolean[] visited, int cur) {
		visited[cur] = true;
		answer++;
		if (cur + arr[cur] <= size && !visited[cur + arr[cur]]) {
			dfs(arr, size, visited, cur + arr[cur]);
		}
		if (cur - arr[cur] >= 1 && !visited[cur - arr[cur]]) {
			dfs(arr, size, visited, cur - arr[cur]);
		}
	}

}
