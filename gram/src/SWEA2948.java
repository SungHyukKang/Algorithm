import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class SWEA2948 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			HashMap<String, Integer> hsmap = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				hsmap.put(str, hsmap.getOrDefault(str, 0) + 1);
			}
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				hsmap.put(str, hsmap.getOrDefault(str, 0) + 1);
			}
			int ans = 0;
			for (Entry<String, Integer> entry : hsmap.entrySet()) {
				if (entry.getValue() == 2) {
					ans++;
				}
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}

}
