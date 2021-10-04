import java.io.*;

public class Baek16916 {

	private static final int MOD1 = 1000000007;
	private static final int MOD2 = 1000000003;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] B = br.readLine().toCharArray();
		char[] S = br.readLine().toCharArray();
		long bKey = 0;
		long bKey2 = 0;
		long sKey = 0;
		long sKey2 = 0;
		long R = 1;
		long R2 = 1;
		if (B.length < S.length) {
			System.out.println(0);
			return;
		}

		for (int i = 0; i < S.length; i++) {
			bKey = ((bKey << 5) + bKey + (B[i] - 'a' + 1) + MOD1) % MOD1;
			bKey2 = ((bKey2 << 5) + bKey2 + (B[i] - 'a' + 1) + MOD2) % MOD2;
			sKey = ((sKey << 5) + sKey + (S[i] - 'a' + 1) + MOD1) % MOD1;
			sKey2 = ((sKey2 << 5) + sKey2 + (S[i] - 'a' + 1) + MOD2) % MOD2;
			R = ((R << 5) + R + MOD1) % MOD1;
			R2 = ((R2 << 5) + R2 + MOD2) % MOD2;
		}
		for (int i = 0; i <= B.length - S.length; i++) {
			if (sKey == bKey && sKey2 == bKey2) {
				System.out.println(1);
				return;
			}
			if (i + S.length < B.length) {
				bKey = ((bKey << 5) + bKey - ((R * (B[i] - 'a' + 1)) % MOD1) + MOD1 + (B[i + S.length] - 'a' + 1))
						% MOD1;
				bKey2 = ((bKey2 << 5) + bKey2 - ((R2 * (B[i] - 'a' + 1)) % MOD2) + MOD2 + B[i + S.length] - 'a' + 1)
						% MOD2;
			}
		}
		System.out.println(0);
	}
}
