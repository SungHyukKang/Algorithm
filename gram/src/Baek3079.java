import java.util.*;
import java.io.*;

public class Baek3079 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		long max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i])
				max = arr[i];
		}
		long start = 1;
		long end = max * M;
		long ans = max * M;
		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				sum += mid / arr[i];
				if (sum >= M)
					break;
			}
			if (sum >= M) {
				ans = Math.min(ans, mid);
				end = mid - 1;
			} else
				start = mid + 1;
		}

		System.out.println(ans);
	}

}
