import java.util.*;
import java.io.*;

public class Baek19951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] preSum = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			preSum[a - 1] += k;
			preSum[b] -= k;
		}
		for (int i = 1; i < N; i++) {
			preSum[i] += preSum[i - 1];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int sum = arr[i] + preSum[i];
			sb.append(sum).append(" ");
		}
		System.out.println(sb);
	}

}
