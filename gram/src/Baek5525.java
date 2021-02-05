import java.io.*;

public class Baek5525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int i = 0;
		int j = 0;
		int cnt = 0;
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		while (j != arr.length) {
			if (arr[i] != 'I') {
				i++;
				j = i;
			} else if (arr[j] == 'I' && i != j) {
				if (j - i == 2) {
					cnt++;
				} else
					cnt = 0;
				i = j;
			} else {
				sb.append(arr[i]);
				j++;
			}
			if (cnt == N) {
				answer++;
				cnt = N - 1;
			}
		}
		System.out.println(answer);
	}

}
