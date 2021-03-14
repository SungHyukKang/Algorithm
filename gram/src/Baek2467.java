import java.util.*;
import java.io.*;

public class Baek2467 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = N - 1;
		int ansmin = 0;
		int ansmax = 0;
		long min = Long.MAX_VALUE;
		while (left < right) {
			int val = arr[left] + arr[right];
			if (min > Math.abs(val)) {
				min = Math.abs(val);
				ansmin = left;
				ansmax = right;
			}

			if (val == 0) {
				ansmin = left;
				ansmax = right;
				break;
			}

			if (val > 0) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(arr[ansmin] + " " + arr[ansmax]);

	}

}
