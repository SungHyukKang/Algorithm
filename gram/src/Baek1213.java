import java.util.*;
import java.io.*;

public class Baek1213 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		Arrays.sort(str);
		HashMap<Character, Integer> hsmap = new LinkedHashMap<>();
		for (int i = 0; i < str.length; i++) {
			hsmap.put(str[i], hsmap.getOrDefault(str[i], 0) + 1);
		}
		StringBuilder sb = new StringBuilder();
		if ((str.length & 1) == 0) {
			for (char c : hsmap.keySet()) {
				for (int i = 0; i < hsmap.get(c) / 2; i++) {
					sb.append(c);
				}
			}
			String answer = sb + "" + sb.reverse();
			if (answer.length() == str.length) {
				System.out.println(answer);
			} else {
				System.out.println("I'm Sorry Hansoo");
			}
		} else {
			int oddcnt = 0;
			char odd = ' ';
			for (char c : hsmap.keySet()) {
				if (oddcnt > 1) {
					break;
				}
				if ((hsmap.get(c) & 1) == 1) {
					oddcnt++;
					odd = c;
				}
				for (int i = 0; i < hsmap.get(c) / 2; i++) {
					sb.append(c);
				}
			}
			if (oddcnt == 1) {
				System.out.println(sb + "" + odd + sb.reverse());
			} else {
				System.out.println("I'm Sorry Hansoo");
			}
		}
	}

}
