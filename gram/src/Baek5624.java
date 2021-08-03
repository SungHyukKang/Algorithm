import java.util.*;
import java.io.*;

public class Baek5624 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] visited = new boolean[400001];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (visited[arr[i] - arr[j] + 200000]) {
					answer++;
					break;
				}
			}
			for (int j = 0; j <= i; j++) {
				visited[arr[i] + arr[j] + 200000] = true;
			}
		}
		System.out.println(answer);

	}
}