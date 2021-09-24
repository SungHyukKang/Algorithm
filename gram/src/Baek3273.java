import java.util.*;
import java.io.*;

public class Baek3273 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);

		int left = 0;
		int right = N - 1;
		int answer = 0;
		while (left < right) {
			if (arr[left] + arr[right] == x) {
				left++;
				right--;
				answer++;
			} else if (arr[left] + arr[right] > x) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(answer);
	}

}
