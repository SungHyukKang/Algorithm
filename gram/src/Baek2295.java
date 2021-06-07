import java.util.*;
import java.io.*;

public class Baek2295 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		ArrayList<Integer> set1 = new ArrayList<>();
		HashSet<Integer> hsset = new HashSet<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int sum = arr[i] + arr[j];
				if (sum < arr[arr.length - 1] && !hsset.contains(sum)) {
					hsset.add(sum);
					set1.add(sum);
				}
			}
		}
		Collections.sort(set1, Collections.reverseOrder());
		for (int i = N - 1; i >= 1; i--) {
			for (int j = i; j >= 0; j--) {
				for (int k : set1) {
					if (arr[i] - arr[j] == k) {
						System.out.println(arr[i]);
						return;
					} else if (arr[i] - arr[j] > k) {
						break;
					}
				}
			}
		}

	}

}
