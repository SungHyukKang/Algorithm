import java.util.*;

public class N개의최소공배수 {
	public static int solution(int[] arr) {
		int answer = 1;
		Arrays.sort(arr);
		int size = arr[arr.length - 1];
		int cnt = 2;
		for (int i = 2; i <= size; i++) {
			cnt = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] % i == 0)
					cnt++;
			}
			if (cnt >= 2) {
				for (int z = 0; z < arr.length; z++) {
					if (arr[z] % i == 0)
						arr[z] /= i;
				}
				answer *= i;
				i = 1;
			}
		}
		for (int c : arr) {
			answer *= c;
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		solution(new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2 });
	}
}
