import java.util.*;
import java.io.*;

public class Baek1701 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int MOD1 = 1000000007;
		int MOD2 = 1000000003;

		int max = 0;
		int start = 0;
		int last = str.length - 1;
		while (start <= last) {
			long hash1 = 0;
			long hash2 = 0;
			long R1 = 1;
			long R2 = 1;
			int mid = (start + last) / 2;
			boolean tf = false;
			for (int i = 0; i < mid; i++) {
				hash1 = ((hash1 << 5) + hash1 + MOD1 + (str[i] - 'a' + 1)) % MOD1;
				hash2 = ((hash2 << 5) + hash2 + MOD2 + (str[i] - 'a' + 1)) % MOD2;
				R1 = ((R1 << 5) + R1 + MOD1) % MOD1;
				R2 = ((R2 << 5) + R2 + MOD2) % MOD2;
			}
			HashSet<Long> hsset = new HashSet<>();
			HashSet<Long> hsset2 = new HashSet<>();
			hsset.add(hash1);
			hsset2.add(hash2);
			for (int i = 0; i < str.length - mid; i++) {
				if (i + mid < str.length) {
					hash1 = ((hash1 << 5) + hash1 - (R1 * (str[i] - 'a' + 1) % MOD1) + MOD1 + (str[i + mid] - 'a' + 1))
							% MOD1;
					hash2 = ((hash2 << 5) + hash2 - (R2 * (str[i] - 'a' + 1) % MOD2) + MOD2 + (str[i + mid] - 'a' + 1))
							% MOD2;
				}
				if (hsset.contains(hash1) && hsset2.contains(hash2)) {
					tf = true;
					break;
				}
				hsset.add(hash1);
				hsset2.add(hash2);
			}
			if (tf) {
				max = mid;
				start = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		System.out.println(max);
	}

}
