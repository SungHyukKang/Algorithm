import java.util.*;
import java.io.*;

public class Baek14467 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hsmap = new HashMap<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int state = Integer.parseInt(st.nextToken());
			if (hsmap.get(num) == null) {
				hsmap.put(num, state);
			} else if (hsmap.get(num) == state) {
				continue;
			} else {
				hsmap.put(num, state);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
