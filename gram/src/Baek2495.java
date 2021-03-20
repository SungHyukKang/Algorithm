import java.util.*;
import java.io.*;

public class Baek2495 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			char[] X = br.readLine().toCharArray();
			char pre = X[0];
			int cnt = 1;
			int max = 0;
			for (int j = 1; j < X.length; j++) {
				char c = X[j];
				if (pre == c) {
					cnt++;
				} else {
					pre = c;
					max = Math.max(cnt, max);
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
			sb.append(max + "\n");
		}
		System.out.println(sb);
	}

}
