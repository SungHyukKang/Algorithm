import java.util.*;
import java.io.*;

public class Baek17390 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i];
		}
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int ans = arr[R] - arr[L - 1];
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
