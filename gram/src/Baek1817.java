import java.util.*;
import java.io.*;

public class Baek1817 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		if (N == 0) {
			System.out.println(0);
			return;
		}
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		int sum = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (sum + arr[i] <= M) {
				sum += arr[i];
			} else {
				answer++;
				sum = arr[i];
			}
		}
		System.out.println(answer + 1);
	}

}
