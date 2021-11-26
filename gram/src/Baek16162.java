import java.util.*;
import java.io.*;

public class Baek16162 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int s = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == A && arr[s] != A) {
				s = i;
			}
		}
		int answer = 0;
		for (int i = s; i < N; i++) {
			int cnt = 0;
			if (arr[i] == A) {
				cnt = 1;
				for (int j = i + 1; j < N; j++) {
					int a = arr[i] + D * (cnt);
					if (arr[j] == a) {
						cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);

	}

}
