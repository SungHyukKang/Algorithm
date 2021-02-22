import java.util.*;
import java.io.*;

public class Baek1072 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long target = (Y * 100 / X) + 1;
		long cnt = 0;
		long start = 1;
		long end = X;
		long mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			long pan = X + mid;
			long win = Y + mid;
			if (target <= (win * 100 / pan)) {
				end = mid - 1;
				cnt = mid;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(cnt == 0 ? "-1" : cnt);
	}

}
