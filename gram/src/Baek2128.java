import java.util.*;
import java.io.*;

public class Baek2128 {
	static boolean[] pro = new boolean[16];
	static int N, D, K;
	static int[] arr;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int bit = Integer.parseInt(st.nextToken());
				bit = (1 << (bit - 1));
				arr[i] = (arr[i] | bit);
			}
		}
		dfs(D, K, 0);
		System.out.println(ans);
	}

	public static void dfs(int D, int K, int bit) {
		if (K == 0) {
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if ((bit & arr[i]) == arr[i]) {
					cnt++;
				}
			}
			ans = Math.max(ans, cnt);
		} else if (D < K)
			return;
		else {
			dfs(D - 1, K - 1, (bit | (1 << (D - 1))));
			dfs(D - 1, K, bit);
		}
	}

}
