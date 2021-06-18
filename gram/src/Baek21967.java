import java.util.*;
import java.io.*;

public class Baek21967 {

	public static int find() {
		int a = 0;
		int b = 0;
		for (int i = 1; i < 11; i++) {
			if (cntArr[i] > 0) {
				a = i;
				break;
			}
		}
		for (int i = 10; i > 0; i--) {
			if (cntArr[i] > 0) {
				b = i;
				break;
			}
		}
		return b - a;
	}

	public static int[] cntArr = new int[11];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		LinkedList<Integer> ll = new LinkedList<>();
		int answer = 0;
		for (int i = 0; i < N; i++) {
			cntArr[arr[i]]++;
			ll.offer(arr[i]);
			while (find() > 2 && !ll.isEmpty()) {
				cntArr[ll.poll()]--;
			}
			answer = Math.max(answer, ll.size());
		}
		System.out.println(answer);
	}

}
