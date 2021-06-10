import java.util.*;
import java.io.*;

public class Baek6168 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int one = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] == 1)
				one++;
		}

		int[] sum = new int[N];
		sum[0] = arr[0];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}
		int answer = 987654321;
		for (int i = 0; i < N; i++) {
			int num = sum[N - 1] - sum[i];// i부터N까지의 누적 합
			int num2 = sum[i] - (i + 1); // i까지의 2의 개수
			int num3 = N - (i + 1);//
			if (i == 0 && num2 == 1)
				num2 = 0;
			int num4 = Math.abs(num - (num3 * 2)); // 오른쪽에 남아있는 1의 개수
			answer = Math.min(answer, Math.abs(num2 + num4));
		}

		System.out.println(answer);

	}
}
