
import java.util.*;
import java.io.*;

class SWEA_2021_07_23_1 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			String won = br.readLine();
			HashMap<Integer, Integer> hsmap = new LinkedHashMap<>();
			int length = won.length();
			int un = (int) Math.pow(10, length - 1);
			hsmap.put(50000, 0);
			hsmap.put(10000, 0);
			hsmap.put(5000, 0);
			hsmap.put(1000, 0);
			hsmap.put(500, 0);
			hsmap.put(100, 0);
			hsmap.put(50, 0);
			hsmap.put(10, 0);
			for (int i = 0; i < won.length() - 1; i++) {
				int s = won.charAt(i) - '0';
				while (s != 0) {
					int swon = s * un;
					if (length >= 6) {
						hsmap.put(50000, hsmap.getOrDefault(50000, 0) + swon / 50000);
						s = 0;
					} else {
						if (s >= 5) {
							hsmap.put(5 * un, hsmap.getOrDefault(5 * un, 0) + s / 5);
							s -= 5;
						} else {
							hsmap.put(un, hsmap.getOrDefault(un, 0) + s);
							s = 0;
						}
					}
				}
				un /= 10;
				length--;
			}
			sb.append("#" + test_case + "\n");
			for (int key : hsmap.keySet()) {
				sb.append(hsmap.get(key) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}