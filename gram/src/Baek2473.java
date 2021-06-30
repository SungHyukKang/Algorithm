import java.util.*;
import java.io.*;

public class Baek2473 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		long result = 3000000001L;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long[] answer = new long[3];
		Arrays.sort(arr);
		for (int i = 0; i < N - 2; i++) {
			int left = i + 1;
			int right = N - 1;
			while (left < right) {
				long val = arr[i] + arr[left] + arr[right];
				if (Math.abs(val) < result) {
					result = Math.abs(val);
					answer[0] = arr[i];
					answer[1] = arr[left];
					answer[2] = arr[right];
				}
				if (val < 0) {
					left++;
				} else
					right--;
			}
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}