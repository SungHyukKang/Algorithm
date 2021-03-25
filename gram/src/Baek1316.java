import java.util.*;
import java.io.*;

public class Baek1316 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while (N-- > 0) {
			char[] X = br.readLine().toCharArray();
			char pre = X[0];
			HashMap<Character, Boolean> hsmap = new HashMap<>();
			hsmap.put(pre, true);
			cnt++;
			for (int i = 1; i < X.length; i++) {
				if (pre == X[i]) {
					continue;
				} else {
					if (hsmap.get(X[i]) != null) {
						cnt--;
						break;
					}
					hsmap.put(pre, true);
					pre = X[i];
				}
			}
		}
		System.out.println(cnt);
	}
}
