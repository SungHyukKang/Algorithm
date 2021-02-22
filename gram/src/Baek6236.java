import java.util.*;
import java.io.*;

public class Baek6236 {
	public static int stoi(String X) {
		return Integer.parseInt(X);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		Integer[] arr = new Integer[N];
		int left = 0;
		int right = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			right += arr[i];
			left = Math.min(left, arr[i]);
		}
		int ans = right;
		while (left <= right) {
			int mid = (left + right) / 2;
			int charge = mid;
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				if (arr[i] > mid) {
					cnt = M + 1;
					break;
				}
				if (charge < arr[i]) {
					charge = mid;
					cnt++;
				}
				charge -= arr[i];
			}
			if (M >= cnt) {
				ans = Math.min(ans, mid);
				right = mid - 1;
			} else
				left = mid + 1;
		}

		System.out.println(ans);

	}

}
