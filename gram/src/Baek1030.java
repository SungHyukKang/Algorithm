import java.util.*;
import java.io.*;

public class Baek1030 {
	static int s, N, K, R1, R2, C1, C2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R1 = Integer.parseInt(st.nextToken());
		R2 = Integer.parseInt(st.nextToken());
		C1 = Integer.parseInt(st.nextToken());
		C2 = Integer.parseInt(st.nextToken());
		int length = (int) Math.pow(N, s);
		StringBuilder sb = new StringBuilder();
		for (int i = R1; i <= R2; i++) {
			for (int j = C1; j <= C2; j++) {
				sb.append(recursive(length, i, j));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static int recursive(int length, int x, int y) {
		if (length == 1)
			return 0;
		int num = length / N;
		int min = num * (N - K) / 2;
		int max = num * (N + K) / 2;
		if (x >= min && x < max && min <= y && max > y)
			return 1;
		return recursive(num, x % num, y % num);
	}

}
