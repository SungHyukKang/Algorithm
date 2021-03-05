import java.util.*;
import java.io.*;

public class Baek14627 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		long T = Integer.parseInt(st.nextToken());
		long[] arr = new long[S];
		long start = 1;
		long end = 1;
		for (int i = 0; i < S; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, arr[i]);
		}
		long ans = 0;
		while (start <= end) {
			long mid = (start + end) / 2;
			if (mid == 0) {
				break;
			}
			long sum = 0;
			for (int i = 0; i < S; i++) {
				sum += arr[i] / mid;
			}

			if (sum >= T) {
				start = mid + 1;
				ans = Math.max(ans, mid);
			} else {
				end = mid - 1;
			}
		}
		ans = ans * T;
		long sum = 0;
		for (int i = 0; i < S; i++)
			sum += arr[i];
		System.out.println(sum - ans);

	}
}
