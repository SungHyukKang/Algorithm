import java.io.*;
import java.util.*;

public class Baek9249 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String aStr = br.readLine();
		String bStr = br.readLine();
		char[] A = aStr.length() > bStr.length() ? aStr.toCharArray() : bStr.toCharArray();
		char[] B = aStr.length() <= bStr.length() ? aStr.toCharArray() : bStr.toCharArray();
		bStr = aStr.length() > bStr.length() ? bStr : aStr;
		int MOD1 = 1000000007;
		int MOD2 = 1000000003;
		int start = 1;
		int end = B.length;
		int answer = 0;
		String answerStr = "";
		while (start <= end) {
			long hash1 = 0;
			long hash2 = 0;
			long hash3 = 0;
			long hash4 = 0;
			long R1 = 1;
			long R2 = 1;
			int mid = (start + end) / 2;
			boolean tf = false;
			for (int i = 0; i < mid; i++) {
				hash1 = (hash1 * 31 + (B[i] - 'a' + 1) + MOD1) % MOD1;
				hash2 = (hash2 * 31 + (B[i] - 'a' + 1) + MOD2) % MOD2;
				hash3 = (hash3 * 31 + (A[i] - 'a' + 1) + MOD1) % MOD1;
				hash4 = (hash4 * 31 + (A[i] - 'a' + 1) + MOD2) % MOD2;
				R1 = (R1 * 31) % MOD1;
				R2 = (R2 * 31) % MOD2;
			}
			HashSet<Long> hsset = new HashSet<>();
			hsset.add(hash3 * MOD1 + hash4);
			for (int i = 0; i < A.length - mid; i++) {
				if (i + mid < A.length) {
					hash3 = ((hash3 * 31 - R1 * (A[i] - 'a' + 1) % MOD1) + MOD1 + A[i + mid] - 'a' + 1) % MOD1;
					hash4 = ((hash4 * 31 - R2 * (A[i] - 'a' + 1) % MOD2) + MOD2 + A[i + mid] - 'a' + 1) % MOD2;
				}
				hsset.add(hash3 * MOD1 + hash4);
			}
			int idx = 0;
			for (int i = 0; i <= B.length - mid; i++) {
				if (hsset.contains(hash1 * MOD1 + hash2)) {
					idx = i;
					tf = true;
					break;
				}
				if (i + mid < B.length) {
					hash1 = ((hash1 * 31 - R1 * (B[i] - 'a' + 1) % MOD1) + MOD1 + B[i + mid] - 'a' + 1) % MOD1;
					hash2 = ((hash2 * 31 - R2 * (B[i] - 'a' + 1) % MOD2) + MOD2 + B[i + mid] - 'a' + 1) % MOD2;
				}
			}

			if (tf) {
				if (answer < mid) {
					answer = mid;
					answerStr = bStr.substring(idx, idx + mid);
				}
				start = mid + 1;
			} else
				end = mid - 1;
		}
		System.out.println(answer);
		System.out.println(answerStr);
	}
}
