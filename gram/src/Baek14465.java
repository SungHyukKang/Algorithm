import java.util.*;
import java.io.*;

public class Baek14465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N + 1];
		for (int i = 0; i < B; i++) {
			visited[Integer.parseInt(br.readLine())] = true;
		}
		int left = 1;
		int right = 1;
		int answer = 100001;
		int cnt = 1;
		int bre = visited[left] ? 1 : 0;
		while (left <= right) {
			if (right == N && right - left <= K) {
				answer = Math.min(answer, bre);
				break;
			}
			if (cnt < K) {
				right++;
				if (visited[right])
					bre++;
				cnt++;
			} else {
				answer = Math.min(answer, bre);
				if (visited[left]) {
					bre--;
				}
				left++;
				cnt--;
			}
		}
		System.out.println(answer == 100001 ? K : answer);
	}

}
