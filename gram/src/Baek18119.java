import java.util.*;
import java.io.*;

public class Baek18119 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int alpha = (int) Math.pow(2, 26) - 1;
		HashMap<Character, Integer> hsmap = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			hsmap.put((char) ('a' + i), (int) Math.pow(2, i));
		}
		int[] list = new int[N];

		for (int i = 0; i < N; i++) {
			String Z = br.readLine();
			boolean[] visited = new boolean[26];
			int sum = 0;
			for (int j = 0; j < Z.length(); j++) {
				if (!visited[Z.charAt(j) - 'a']) {
					visited[Z.charAt(j) - 'a'] = true;
					sum += hsmap.get(Z.charAt(j));
				}
			}
			list[i] = sum;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			if (num == 1) {
				alpha = alpha - hsmap.get(c);
			} else {
				alpha = alpha + hsmap.get(c);
			}
			int cnt = 0;
			for (int j = 0; j < list.length; j++) {
				if ((list[j] & alpha) == list[j]) {
					cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
