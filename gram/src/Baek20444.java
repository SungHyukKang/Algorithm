import java.util.*;
import java.io.*;

public class Baek20444 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		long start = 0;
		long end = n;
		while (start <= end) {
			long mid = (start + end) / 2;
			if ((n - mid + 1) * (mid + 1) < k) {
				start = mid + 1;
			} else if ((n - mid + 1) * (mid + 1) > k) {
				end = mid - 1;
			} else {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

}
