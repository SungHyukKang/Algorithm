import java.util.*;
import java.io.*;

public class SWEA10806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {

			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] <= o2[0] ? -1 : 1);
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int K = Integer.parseInt(br.readLine());
			pq.offer(new int[] { 0, K });
			while (pq.peek()[1] != 0) {
				int[] p = pq.poll();
				pq.offer(new int[] { p[0] + K, 0 });
				for (int i = 0; i < N; i++) {
					pq.offer(new int[] { p[0] + p[1] % arr[i], p[1] / arr[i] });
				}
			}
			sb.append("#" + t + " " + pq.peek()[0]+"\n");
		}
		System.out.println(sb);
	}

}
