import java.util.*;
import java.io.*;

public class Baek1500 {
	static int S;
	static int K;
	static Stack<Integer> stack = new Stack<>();
	static long max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		for (int i = 0; i < K; i++)
			arr[i] = S / K;
		for (int i = 0; i < S - S / K * K; i++) {
			arr[i]++;
		}
		long ans = 1;
		for (int i = 0; i < K; i++) {
			ans *= arr[i];
		}
		System.out.println(ans);
	}

}
