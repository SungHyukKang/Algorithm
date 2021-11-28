import java.util.*;
import java.io.*;

public class Baek2531 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] visited = new int[d + 1];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			visited = new int[d + 1];
			visited[arr[i]]++;
			int cnt = 1;
			for (int j = i; j < i + k; j++) {
				int idx = j % N;
				if (visited[arr[idx]] == 0) {
					cnt++;
				}
				visited[arr[idx]]++;
				ans = Math.max(ans, visited[c] == 0 ? cnt + 1 : cnt);
			}
		}
		System.out.println(ans);

	}

}
