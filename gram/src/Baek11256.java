import java.util.*;
import java.io.*;

public class Baek11256 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			Integer[] arr = new Integer[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				arr[i] = r * c;
			}
			Arrays.sort(arr, Collections.reverseOrder());
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (sum >= j) {
					sb.append(i + "\n");
					break;
				}
				sum += arr[i];
			}
		}
		System.out.println(sb);
	}

}
