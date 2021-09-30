import java.util.*;
import java.io.*;

public class Baek20437 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		while (T-- > 0) {
			String s = br.readLine();
			char[] str = s.toCharArray();
			int k = Integer.parseInt(br.readLine());
			if (k == 1) {
				answer.append("1 1\n");
				continue;
			}
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			boolean tf = true;
			HashMap<Character, Integer> hsmap = new HashMap<>();
			for (int i = 0; i < str.length; i++) {
				hsmap.put(str[i], hsmap.getOrDefault(str[i], 0) + 1);
			}
			for (int i = 0; i < str.length; i++) {
				if (hsmap.get(str[i]) < k) {
					continue;
				}
				int cnt = 1;
				for (int j = i + 1; j < str.length; j++) {
					if (str[i] == str[j])
						cnt++;
					if (cnt == k) {
						min = Math.min(min, j - i + 1);
						max = Math.max(max, j - i + 1);
						tf = false;
						break;
					}
				}
			}
			if (tf) {
				answer.append(-1).append("\n");
			} else
				answer.append(min).append(" ").append(max).append("\n");
		}
		System.out.println(answer);
	}

}
