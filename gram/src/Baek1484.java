import java.util.*;
import java.io.*;

public class Baek1484 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		long left = 1;
		long right = 1;
		Set<Long> hsset = new LinkedHashSet<>();
		while (true) {
			long a = left * left;
			long b = right * right;
			if (right - left == 1 && b - a > G)
				break;
			if (b - a <= G) {
				if (b - a == G) {
					hsset.add(right);
				}
				right++;
			} else {
				left++;
			}
		}
		StringBuilder sb = new StringBuilder();
		if (hsset.size() == 0) {
			System.out.println("-1");
			return;
		}
		for (long x : hsset) {
			sb.append(x).append("\n");
		}
		System.out.println(sb);
	}

}
