import java.io.*;
import java.math.BigInteger;

public class Baek1247 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 3;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			BigInteger bi = new BigInteger(br.readLine());
			for (int i = 0; i < N - 1; i++) {
				bi = bi.add(new BigInteger(br.readLine()));
			}
			int ans = bi.compareTo(new BigInteger("0"));
			sb.append(ans == 0 ? 0 : ans < 0 ? "-" : "+").append("\n");
		}
		System.out.println(sb);
	}

}
