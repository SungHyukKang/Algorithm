import java.util.*;
import java.io.*;

public class Baek10384 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashMap<Character, Integer> hsmap = new HashMap<>();
			for (int j = 0; j < 26; j++) {
				hsmap.put((char) ('a' + j), 0);
			}
			while (st.hasMoreElements()) {
				String X = st.nextToken().toLowerCase();
				for (int j = 0; j < X.length(); j++) {
					char c = X.charAt(j);
					if ((int) c < 97 || (int) c > 122)
						continue;
					hsmap.put(c, hsmap.getOrDefault(c, 0) + 1);
				}
			}
			int min = Integer.MAX_VALUE;

			for (int x : hsmap.values()) {
				if (min > x)
					min = x;
			}

			if (min == 0) {
				sb.append("Case " + i + ": Not a pangram\n");
			} else if (min == 1) {
				sb.append("Case " + i + ": Pangram!\n");
			} else if (min == 2) {
				sb.append("Case " + i + ": Double pangram!!\n");
			} else {
				sb.append("Case " + i + ": Triple pangram!!!\n");
			}
		}
		System.out.println(sb);
	}

}
