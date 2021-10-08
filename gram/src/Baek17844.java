import java.util.*;
import java.io.*;

public class Baek17844 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] ch = str.toCharArray();
		int start = 1;
		int end = ch.length;
		int MOD1 = 1000000007;
		int MOD2 = 1000000003;
		int answer = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			HashMap<Long, Integer> hsmap = new HashMap<>();
			long hash1 = 0;
			long hash2 = 0;
			long R = 1;
			long R2 = 1;
			boolean tf = false;
			for (int i = 0; i < mid; i++) {
				hash1 = (hash1 * 31 + (ch[i] - 'a' + 1) + MOD1) % MOD1;
				hash2 = (hash2 * 31 + (ch[i] - 'a' + 1) + MOD2) % MOD2;
				R = (R * 31 + MOD1) % MOD1;
				R2 = (R2 * 31 + MOD2) % MOD2;
			}
			hsmap.put(hash1 * MOD1 + hash2, mid - 1);
			for (int i = 0; i < ch.length - mid; i++) {
				if (i + mid < ch.length) {
					hash1 = (hash1 * 31 - (R * (ch[i] - 'a' + 1) % MOD1) + MOD1 + (ch[i + mid] - 'a' + 1)) % MOD1;
					hash2 = (hash2 * 31 - (R2 * (ch[i] - 'a' + 1) % MOD2) + MOD2 + (ch[i + mid] - 'a' + 1)) % MOD2;
				}
				if (hsmap.get(hash1 * MOD1 + hash2) != null && hsmap.get(hash1 * MOD1 + hash2) < (i + 1)) {
					tf = true;
					break;
				}
				if (hsmap.get(hash1 * MOD1 + hash2) == null) {
					hsmap.put(hash1 * MOD1 + hash2, i + mid);
				}
			}
			if (tf) {
				start = mid + 1;
				answer = mid;
			} else {
				end = mid - 1;
			}
		}
		System.out.println( answer);
	}

}
