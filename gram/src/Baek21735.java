import java.util.*;
import java.io.*;

public class Baek21735 {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N + 1];
		dfs(0, M, 1);
		System.out.println(max);
	}

	public static void dfs(int idx, int m, int sum) {
		if (idx == N || m == 0) {
			max = Math.max(sum, max);
			return;
		}
		if (idx + 1 <= N) {
			dfs(idx + 1, m - 1, sum + arr[idx + 1]);
		}
		if (idx + 2 <= N) {
			dfs(idx + 2, m - 1, sum / 2 + arr[idx + 2]);
		}
	}

}
