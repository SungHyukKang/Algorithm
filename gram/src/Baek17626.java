import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek17626 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[50001];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i <= N; i++) {
			if (Math.round(Math.sqrt(i)) == Math.sqrt(i)) {
				arr[i] = 1;
				continue;
			}
			int min = 987654321;
			for (int j = (int) Math.sqrt(i); j >= 1; j--) {
				if (min > arr[i - j * j] + 1) {
					min = arr[i - j * j] + 1;
				}
			}
			arr[i] = min;
		}

		System.out.println(arr[N]);

	}

}
