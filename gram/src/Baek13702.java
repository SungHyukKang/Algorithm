import java.util.*;
import java.io.*;

public class Baek13702 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int left = 1;
		int right = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, arr[i]);
		}
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				cnt += arr[i] / mid;
			}

			if (cnt >= K) {
				ans = Math.max(ans, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}
		System.out.println(ans);

	}

}
