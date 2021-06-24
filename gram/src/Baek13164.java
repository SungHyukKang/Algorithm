import java.util.*;
import java.io.*;

public class Baek13164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N - 1; i++) {
			list.add(arr[i + 1] - arr[i]);
		}
		Collections.sort(list, Collections.reverseOrder());
		int answer = 0;
		for (int i = K - 1; i < list.size(); i++) {
			answer += list.get(i);
		}
		System.out.println(answer);
	}

}
