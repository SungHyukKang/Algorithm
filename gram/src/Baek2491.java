import java.util.*;
import java.io.*;

public class Baek2491 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 1;
		int leng = 1;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] <= arr[i + 1]) {
				leng++;
				answer = Math.max(answer, leng);
			} else {
				answer = Math.max(answer, leng);
				leng = 1;
			}
		}
		leng = 1;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] >= arr[i + 1]) {
				leng++;
				answer = Math.max(answer, leng);
			} else {
				answer = Math.max(answer, leng);
				leng = 1;
			}
		}
		System.out.println(answer);
	}

}
