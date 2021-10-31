import java.util.*;
import java.io.*;

public class Baek5883 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		HashSet<Integer> hsset = new HashSet<>();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			hsset.add(arr[i]);
		}
		int answer = 0;
		for (int x : hsset) {
			int cur = arr[0];
			int cnt = 1;
			for (int i = 1; i < N; i++) {
				if (arr[i] == x) {
					continue;
				}
				if (arr[i] == cur) {
					cnt++;
				} else {
					answer = Math.max(cnt, answer);
					cur = arr[i];
					cnt = 1;
				}
			}
			answer = Math.max(cnt, answer);
		}
		System.out.println(answer);
	}

}
