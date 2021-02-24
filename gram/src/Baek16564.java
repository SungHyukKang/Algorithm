import java.util.*;
import java.io.*;

public class Baek16564 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int s = Integer.MAX_VALUE;
		int e = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			s = Math.min(s, arr[i]);
			e = Math.max(e, arr[i]);
		}
		int ans = 0;
		while (s <= e) {
			int mid = (s + e) / 2;
			long sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (mid > arr[i]) {
					sum += mid - arr[i];
				}
				if (sum > K)
					break;
			}

			if (sum > K) {
				e = mid - 1;
			} else {
				ans = Math.max(ans, mid);
				s = mid + 1;
			}

		}
		System.out.println(ans);
	}

}
