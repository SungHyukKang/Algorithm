import java.util.*;
import java.io.*;

public class Baek2447 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(recursive(N, i, j));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static char recursive(int N, int x, int y) {
		if (N == 1) {
			return '*';
		}
		int leng = N / 3;
		if (x >= leng && x < leng * 2 && y >= leng && y < leng * 2)
			return ' ';
		return recursive(leng, x % leng, y % leng);
	}

}
