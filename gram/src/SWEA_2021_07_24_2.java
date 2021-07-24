import java.util.*;
import java.io.*;

public class SWEA_2021_07_24_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[201];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int min = Math.min(a, b);
				int max = Math.max(a, b);
				if ((min & 1) == 1) {
					min++;
				}
				if ((max & 1) == 1) {
					max++;
				}
				min /= 2;
				max /= 2;
				for (int j = min; j <= max; j++) {
					arr[j]++;
				}
			}
			int answer = 0;
			for (int i = 0; i <= 200; i++) {
				answer = Math.max(answer, arr[i]);
			}
			sb.append("#" + test_case + " " + answer + "\n");

		}
		System.out.println(sb);
	}

}
