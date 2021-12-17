import java.util.*;
import java.io.*;

public class Baek9177 {
	static int N;
	static String str;
	static char[] ch1;
	static char[] ch2;
	static boolean tf;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ch1 = st.nextToken().toCharArray();
			ch2 = st.nextToken().toCharArray();
			str = st.nextToken();
			tf = false;
			boolean[][] visited = new boolean[ch1.length + 1][ch2.length + 1];
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { 0, 0, 0 });
			visited[0][0] = true;
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				if (cur[2] == str.length()) {
					sb.append("Data set ").append(i).append(": yes\n");
					tf = true;
					break;
				}
				if (cur[0] < ch1.length && !visited[cur[0] + 1][cur[1]] && ch1[cur[0]] == str.charAt(cur[2])) {
					visited[cur[0] + 1][cur[1]] = true;
					q.offer(new int[] { cur[0] + 1, cur[1], cur[2] + 1 });
				}
				if (cur[1] < ch2.length && !visited[cur[0]][cur[1] + 1] && ch2[cur[1]] == str.charAt(cur[2])) {
					visited[cur[0]][cur[1] + 1] = true;
					q.offer(new int[] { cur[0], cur[1] + 1, cur[2] + 1 });

				}

			}
			if (!tf)
				sb.append("Data set ").append(i).append(": no\n");
		}
		System.out.println(sb);
	}

}
