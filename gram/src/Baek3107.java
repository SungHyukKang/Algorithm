import java.util.*;
import java.io.*;

public class Baek3107 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(":");
		StringBuilder sb = new StringBuilder();
		if (str.length == 8) {
			for (String s : str) {
				if (s.length() == 4) {
					sb.append(s).append(":");
				} else {
					for (int i = 0; i < 4 - s.length(); i++) {
						sb.append(0);
					}
					sb.append(s).append(":");
				}
			}
			System.out.println(sb.substring(0, sb.length() - 1));
		} else {
			boolean tf = false;
			if (str.length == 0) {
				System.out.println("0000:0000:0000:0000:0000:0000:0000:0000");
				return;
			}
			for (int j = 0; j < str.length; j++) {
				String s = str[j];
				if (s.length() == 4) {
					sb.append(s).append(":");
				} else if (s.equals("") && !tf) {
					tf = true;
					int cnt = 0;
					if (j + 1 < str.length && str[j + 1].equals("")) {
						j++;
						cnt = 1;
					}
					for (int i = 0; i < 8 - (str.length - 1 - j) - j + cnt; i++) {
						sb.append("0000").append(":");
					}
				} else {
					for (int i = 0; i < 4 - s.length(); i++) {
						sb.append(0);
					}
					sb.append(s).append(":");
				}
			}
			if (sb.length() != 40)
				for (int i = 0; i < 8 - str.length; i++) {
					sb.append("0000").append(":");
				}

			System.out.println(sb.substring(0, sb.length() - 1));
		}
	}

}
