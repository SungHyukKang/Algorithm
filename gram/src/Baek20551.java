import java.util.*;
import java.io.*;

public class Baek20551 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		HashMap<Integer, Integer> hsmap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			if (hsmap.get(arr[i]) == null)
				hsmap.put(arr[i], i);
		}
		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if (hsmap.get(num) == null) {
				sb.append(-1).append("\n");
			} else {
				sb.append(hsmap.get(num)).append("\n");
			}
		}
		System.out.println(sb);
	}

}
