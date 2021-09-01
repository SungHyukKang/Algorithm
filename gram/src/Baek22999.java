import java.util.*;
import java.io.*;

public class Baek22999 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			char[] str = br.readLine().toCharArray();
			int cnt = 0;
			for (int i = 0; i < N / 2; i++) {
				if (str[i] != str[N - 1 - i]) {
					cnt++;
				}
			}
			sb.append("Case #" + t + ": " + Math.abs(K - cnt) + "\n");
		}
		System.out.println(sb);
	}

}
