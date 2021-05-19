import java.io.*;

public class Baek21734 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charr = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < charr.length; i++) {
			String X = String.valueOf((int) charr[i]);
			int sum = 0;
			for (int j = 0; j < X.length(); j++) {
				sum += X.charAt(j) - '0';
			}
			for (int j = 0; j < sum; j++) {
				sb.append(charr[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
