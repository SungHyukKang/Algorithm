import java.util.*;
import java.io.*;

public class Baek21737 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		String susik = br.readLine();
		if (susik.length() == susik.replace("C", "").length()) {
			System.out.println("NO OUTPUT");
			return;
		}
		char[] ss = susik.toCharArray();
		int ret = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(ss[0]);
		int size = 0;
		for (int i = ss.length - 1; i >= 0; i--) {
			if (ss[i] == 'C') {
				size = i;
				break;
			}
		}
		for (int i = 1; i <= size; i++) {
			if (ss[i] <= '9') {
				sb.append(ss[i]);
			} else if (ss[i] == 'S') {
				i++;
				ret = Integer.parseInt(sb.toString());
				sb = new StringBuilder();
				while (true) {
					if (ss[i] > '9') {
						i--;
						ret -= Integer.parseInt(sb.toString());
						sb = new StringBuilder().append(ret);
						break;
					} else {
						sb.append(ss[i]);
					}
					i++;
				}
			} else if (ss[i] == 'M') {
				i++;
				ret = Integer.parseInt(sb.toString());
				sb = new StringBuilder();
				while (true) {
					if (ss[i] > '9') {
						i--;
						ret *= Integer.parseInt(sb.toString());
						sb = new StringBuilder().append(ret);
						break;
					} else {
						sb.append(ss[i]);
					}
					i++;
				}

			} else if (ss[i] == 'U') {
				i++;
				ret = Integer.parseInt(sb.toString());
				sb = new StringBuilder();
				while (true) {
					if (ss[i] > '9') {
						i--;
						ret /= Integer.parseInt(sb.toString());
						sb = new StringBuilder().append(ret);
						break;
					} else {
						sb.append(ss[i]);
					}
					i++;
				}
			} else if (ss[i] == 'P') {
				i++;
				ret = Integer.parseInt(sb.toString());
				sb = new StringBuilder();
				while (true) {
					if (ss[i] > '9') {
						i--;
						ret += Integer.parseInt(sb.toString());
						sb = new StringBuilder().append(ret);
						break;
					} else {
						sb.append(ss[i]);
					}
					i++;
				}
			} else {
				answer.append(Integer.parseInt(sb.toString()) + " ");
			}
		}
		System.out.println(answer);
	}

}
