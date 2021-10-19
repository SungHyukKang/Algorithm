import java.util.*;
import java.io.*;

public class Baek2539 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(br.readLine().trim());
		int miss = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[miss];
		int start = 0;
		int end = M;
		for (int i = 0; i < miss; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr[i] = h;
			start = Math.max(start, w);
		}

		int answer = M;
		Arrays.sort(arr);
		while (start <= end) {
			int mid = (start + end) / 2;
			int cnt = 1;
			int l = arr[0];
			int r = arr[0];
			for (int i = 1; i < miss; i++) {
				r = arr[i];
				if (r - l >= mid) {
					cnt++;
					l = arr[i];
					r = arr[i];
				}
			}
			if (cnt <= count) {
				end = mid - 1;
				answer = Math.min(answer, mid);
			} else {
				start = mid + 1;
			}
		}
		System.out.println(answer);

	}

}
