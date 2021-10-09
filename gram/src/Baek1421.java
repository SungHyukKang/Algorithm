import java.util.*;
import java.io.*;

public class Baek1421 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		HashMap<Long, Integer> hsmap = new HashMap<>();
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			hsmap.put((long) arr[i], hsmap.getOrDefault((long) arr[i], 0) + 1);
			max = max < arr[i] ? arr[i] : max;
		}
		long answer = 0;
		for (long num : hsmap.keySet()) {
			answer = Math.max(answer, num * hsmap.get(num) * W);
		}
		for (int i = 1; i <= max; i++) {
			long sum = 0;
			for (int j = 0; j < N; j++) {
				int piece = (arr[j] - arr[j] % i) * W;
				int cut = (arr[j] % i == 0 ? arr[j] / i - 1 : arr[j] / i) * C;

				if (cut < piece) {
					sum += piece - cut;
				}
			}
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}

}
