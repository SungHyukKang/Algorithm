import java.util.*;
import java.io.*;

public class Baek2866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] ch = new char[R][C];
		for (int i = 0; i < R; i++)
			ch[i] = br.readLine().toCharArray();
		int left = 1;
		int right = C;
		int answer = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			boolean tf = true;
			HashSet<String> hsset = new HashSet<>();
			for (int i = 0; i < C; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = mid; j < R; j++) {
					sb.append(ch[j][i]);
				}
				if (!hsset.contains(sb.toString())) {
					hsset.add(sb.toString());
				} else {
					tf = false;
					break;
				}
			}
			if (tf) {
				left = mid + 1;
				answer = Math.max(answer, mid);
			} else {
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}

}
