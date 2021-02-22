import java.util.*;
import java.io.*;

public class Baek2343 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		long start = max;
		long end = 1000000000;
		long ans = Long.MAX_VALUE;
		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			int cnt = 1;
			System.out.println(mid);
			for (int i = 0; i < N;) {
				sum += arr[i];
				if (sum <= mid) {
					i++;
				} else {
					cnt++;
					sum = 0;
				}
			}
			if (cnt <= M) {
				ans = Math.min(ans, mid);
				end = mid - 1;
			} else
				start = mid + 1;

		}
		System.out.println(ans);
	}

}
