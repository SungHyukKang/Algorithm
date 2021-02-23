import java.util.*;
import java.io.*;

public class Baek20922 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		int[] a = new int[100001];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int s = 1;
		int e = 1;
		int max = 0;
		while (e < arr.length) {
			max = Math.max(max, e - s);
			if (a[arr[e]] + 1 <= K) {
				a[arr[e]]++;
				e++;
			} else if (a[arr[e]] + 1 > K) {
				max = Math.max(max, e - s);
				for (int i = s; i < e; i++) {
					a[arr[i]]--;
					if (arr[i] == arr[e]) {
						s = i + 1;
						break;
					}
				}
			}
		}
		max = Math.max(max, e - s);
		System.out.println(max);
	}

}
