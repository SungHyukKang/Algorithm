import java.io.*;

public class Baek2998 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine()).reverse();
		while (true) {
			if (sb.length() % 3 == 0) {
				break;
			}
			sb.append(0);
		}
		sb = sb.reverse();
		char[] chArr = sb.toString().toCharArray();
		int decimal = 0;
		int mod = 0;
		sb = new StringBuilder();
		for (int i = chArr.length - 1; i >= 0; i--) {
			int cToi = chArr[i] - '0';
			if (cToi == 1) {
				decimal += (cToi << (mod % 3));
			}
			if ((mod + 1) % 3 == 0 && mod != 0) {
				sb.append(decimal);
				decimal = 0;
			}
			mod++;
		}
		System.out.println(sb.reverse());
	}

}
