import java.util.*;
import java.io.*;

public class Baek12847 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long[] sum = new long[N];
		sum[0] = arr[0];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}
		if (M == 0) {
			System.out.println("0");
			return;
		}

		if (N == M) {
			System.out.println(sum[N - 1]);
			return;
		}
		long answer = sum[M - 1];
		for (int i = 0; i < N - M; i++) {
			answer = Math.max(answer, sum[i + M] - sum[i]);
		}

		System.out.println(answer);
	}

}
