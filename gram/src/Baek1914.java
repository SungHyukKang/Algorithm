import java.io.*;
import java.math.BigInteger;

public class Baek1914 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int k = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		if (k > 20) {
			BigInteger bi = new BigInteger("2");
			System.out.println(bi.pow(k).subtract(new BigInteger("1")));
		} else {
			System.out.println((int) Math.pow(2, k) - 1);
			hanoi(1, 3, k);
			bw.flush();
		}
	}

	public static void hanoi(int i, int j, int k) throws IOException {
		if (k == 0)
			return;
		hanoi(i, 6 - i - j, k - 1);
		bw.write(i + " " + j);
		bw.newLine();
		hanoi(6 - i - j, j, k - 1);
	}

}
