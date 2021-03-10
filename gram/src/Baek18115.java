import java.util.*;
import java.io.*;

public class Baek18115 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Deque<Integer> list = new LinkedList<>();
		for (int i = 0; i < N; i++)
			list.add(i);
		StringTokenizer st = new StringTokenizer(br.readLine());

		while (!list.isEmpty()) {
			int c = Integer.parseInt(st.nextToken());
			if (c == 1) {
				int first = list.poll();
				arr[first] = N--;
			} else if (c == 2) {
				int first = list.poll();
				int second = list.poll();
				arr[second] = N--;
				list.offerFirst(first);
			} else {
				int last = list.pollLast();
				arr[last] = N--;
			}
		}

		for (int C : arr)
			bw.write(C + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
