import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Baek2407 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] dp = new long[101];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		BigInteger[] bi = new BigInteger[101];

		dp[1] = 1;
		dp[2] = 2;
		String X = "2";
		for (int i = 3; i <= 100; i++) {
			BigInteger o = new BigInteger(X);
			BigInteger o2 = new BigInteger(String.valueOf(i));
			bi[i] = o.multiply(o2);
			X = bi[i].toString();
		}
		bw.write(bi[n].divide(bi[n - m].multiply(bi[m])).toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
