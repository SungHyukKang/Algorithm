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
		int[] arr = new int[N * 2];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int idx = 0;
		for (int i = N; i < N + k + 1; i++) {
			arr[i] = arr[idx++];
		}
		int[] visited = new int[d + 1];

		int s = 0;
		int e = 0;
		int cnt = 0;
		int ans = 0;
		while (s <= e) {
			if (e == N * 2)
				break;
			if (visited[arr[e]] == 0 && cnt < k) {
				visited[arr[e]]++;
				e++;
				cnt++;
				if (visited[c] == 0) {
					ans = Math.max(ans, cnt + 1);
				}
			} else {
				visited[arr[s]]--;
				s++;
				cnt--;
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}

}
