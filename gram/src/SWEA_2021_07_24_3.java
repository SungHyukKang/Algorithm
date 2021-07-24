import java.util.*;
import java.io.*;

public class SWEA_2021_07_24_3 {
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] arr = st.nextToken().toCharArray();
			int N = Integer.parseInt(st.nextToken());
			boolean[][] visited = new boolean[1000000][11];
			max = 0;
			dfs(arr, N, visited);
			sb.append("#" + test_case + " " + max + "\n");
		}
		System.out.println(sb);
	}

	public static void dfs(char[] arr, int chance, boolean[][] visited) {
		if (chance == 0) {
			StringBuilder sb = new StringBuilder();
			for (char x : arr) {
				sb.append(x);
			}
			max = Math.max(max, Integer.parseInt(sb.toString()));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				char temp1 = arr[i];
				char temp2 = arr[j];
				arr[i] = temp2;
				arr[j] = temp1;
				int num = stoi(arr);
				if (!visited[num][chance - 1]) {
					visited[num][chance - 1] = true;
					dfs(arr, chance - 1, visited);
				}
				arr[i] = temp1;
				arr[j] = temp2;
			}
		}

	}

	public static int stoi(char[] arr) {
		StringBuilder sb = new StringBuilder();
		for (char z : arr) {
			sb.append(z);
		}
		return Integer.parseInt(sb.toString());
	}

}
