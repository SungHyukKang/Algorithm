import java.util.*;
import java.io.*;

class SWEA_2021_07_19_01 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			long X = Long.parseLong(br.readLine());
			HashSet<Integer> hsset = new HashSet<>();
			int gob = 1;
			while (true) {
				long Z = X * gob;
				while (Z > 0) {
					hsset.add((int) (Z % 10));
					Z /= 10;
				}
				if (hsset.size() == 10) {
					sb.append("#" + test_case + " " + X * gob + "\n");
					break;
				}
				gob++;
			}
		}
		System.out.println(sb);
	}
}