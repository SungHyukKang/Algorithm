import java.util.*;
import java.io.*;

public class Baek20127 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		Queue<Integer> list2 = new LinkedList<>();
		Queue<Integer> list3 = new LinkedList<>();
		int INF = Integer.MAX_VALUE;
		int max = 0;
		int min = INF;
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[i] = x;
			list2.add(x);
			list3.add(x);
			if (min > x) {
				min = x;
			}
			if (max < x)
				max = x;
		}
		int cnt1 = 0;
		for (int i = 0; i < N; i++) {
			int x = list2.peek();
			if (x == min) {
				break;
			}
			list2.poll();
			list2.offer(x);
			cnt1++;
		}
		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			int x = list3.peek();
			if (x == max) {
				break;
			}
			list3.poll();
			list3.offer(x);
			cnt2++;
		}
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			int x = arr[i];
			int y = list2.poll();
			if (x != y) {
				cnt1 = INF;
				break;
			}
		}
		for (int i = N - 1; i >= 0; i--) {
			int x = arr[i];
			int y = list3.poll();
			if (x != y) {
				cnt2 = INF;
				break;
			}
		}
		int answer = Math.min(cnt1, cnt2);
		if (answer == INF) {
			System.out.println("-1");
		} else
			System.out.println(answer);
	}

}
