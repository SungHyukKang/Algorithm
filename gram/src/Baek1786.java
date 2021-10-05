import java.util.*;
import java.io.*;

public class Baek1786 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		if (A.length < B.length) {
			System.out.println(0);
			return;
		}
		int MOD1 = 1000000007;
		int MOD2 = 1000000003;
		long hash1 = 0;
		long hash2 = 0;
		long hash3 = 0;
		long hash4 = 0;
		long R1 = 1;
		long R2 = 1;
		for (int i = 0; i < B.length; i++) {
			hash1 = ((hash1 << 5) + hash1 + A[i] + MOD1) % MOD1;
			hash2 = ((hash2 << 5) + hash2 + A[i] + MOD2) % MOD2;
			hash3 = ((hash3 << 5) + hash3 + B[i] + MOD1) % MOD1;
			hash4 = ((hash4 << 5) + hash4 + B[i] + MOD2) % MOD2;
			R1 = ((R1 << 5) + R1 + MOD1) % MOD1;
			R2 = ((R2 << 5) + R2 + MOD2) % MOD2;
		}
		StringBuilder sb2 = new StringBuilder();
		int cnt = 0;
		for (int i = 0; i <= A.length - B.length; i++) {
			if (hash1 == hash3 && hash2 == hash4) {
				sb2.append(i + 1).append(" ");
				cnt++;
			}
			if (i + B.length < A.length) {
				hash1 = (((hash1 << 5) + hash1 - (R1 * A[i]) % MOD1) + MOD1 + A[i + B.length]) % MOD1;
				hash2 = (((hash2 << 5) + hash2 - (R2 * A[i]) % MOD2) + MOD2 + A[i + B.length]) % MOD2;
			}
		}
		System.out.println(cnt);
		System.out.println(sb2.toString());
	}

}
