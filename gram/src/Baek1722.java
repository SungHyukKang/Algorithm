import java.util.*;
import java.io.*;

public class Baek1722 {
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		long[] factorial = new long[21];
		factorial[0] = 1;
		int[] arr = new int[N];
		for (int i = 1; i < 21; i++) {
			factorial[i] = factorial[i - 1] * i;
		}
		if (num == 1) {
			long k = Long.parseLong(st.nextToken());
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= N; j++) {
					if (visited[j])
						continue;
					if (factorial[N - i - 1] < k) {
						k -= factorial[N - i - 1];
					} else {
						arr[i] = j;
						visited[j] = true;
						break;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}

		} else {
			long cnt = 0;
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < arr[i]; j++) {
					if (!visited[j]) {
						cnt += factorial[N - i - 1];
					}
				}
				visited[arr[i]] = true;
			}
			System.out.println(cnt + 1);
		}
	}
}
