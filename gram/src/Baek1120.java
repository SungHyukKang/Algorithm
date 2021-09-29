import java.util.*;
import java.io.*;

public class Baek1120 {

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		if (A.length() == B.length()) {
			int cnt = 0;
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) != B.charAt(i)) {
					cnt++;
				}
			}
			System.out.println(cnt);
		} else {
			int leng = B.length() - A.length();
			int ans = 987654321;
			for (int i = 0; i <= leng; i++) {
				int cnt = 0;
				for (int j = 0; j < A.length(); j++) {
					if (A.charAt(j) != B.charAt(i + j)) {
						cnt++;
					}
				}
				ans = Math.min(cnt, ans);
			}
			System.out.println(ans);
		}
	}

}
