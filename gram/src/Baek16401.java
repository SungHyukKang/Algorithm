import java.util.*;
import java.io.*;

public class Baek16401{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		int left = 1;
		int right = 0;
		int ans = 0;
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}

		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				if (arr[i] >= mid) {
					cnt += arr[i] / mid;
				}
				if(cnt>=N)
					break;
			}

			if (cnt >= N) {
				left = mid + 1;
				ans = Math.max(mid, ans);
			} else {
				right = mid - 1;
			}
		}

		System.out.println(ans);
	}

}
