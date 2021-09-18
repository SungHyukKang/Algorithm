import java.util.*;
import java.io.*;

public class Baek23055 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
					sb.append("*");
					continue;
				}
				if (j == i || N - j - 1 == i) {
					sb.append("*");
				} else
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
