import java.util.*;
import java.io.*;

public class SWEA10507 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int z = 1; z <= T; z++) {
			sb.append("#" + z + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			boolean[] study = new boolean[1000001];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int day = Integer.parseInt(st.nextToken());
				study[day] = true;
			}
			int start = 0;
			int end = 0;
			int cnt = 0;
			int max = p + 1;
			while (end < study.length) {
				if (study[end]) {
					cnt++;
					end++;
					max = Math.max(max, cnt);
				} else {
					if (p == 0) {
						max = Math.max(max, cnt);
						if (!study[start]) {
							p++;
						}
						start++;
						cnt--;
					} else {
						end++;
						cnt++;
						p--;
					}
				}
			}
			sb.append(max + "\n");

		}
		System.out.println(sb);
	}

}
