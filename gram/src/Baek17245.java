import java.util.*;
import java.io.*;

public class Baek17245 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] arr = new long[N][N];
		long max = 0;
		long chong = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				long x = Long.parseLong(st.nextToken());
				arr[i][j] = x;
				if (max < arr[i][j])
					max = arr[i][j];
				chong += arr[i][j];
			}
		}
		if (max == 0) {
			System.out.println(0);
			return;
		}
		long start = 0;
		long end = max;
		long ans = max;
		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] < mid) {
						sum += arr[i][j];
					} else
						sum += mid;
				}
			}
			sum = (sum * 100 / chong);
			if (sum >= 50) {
				ans = Math.min(ans, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		System.out.println(ans);
	}

}