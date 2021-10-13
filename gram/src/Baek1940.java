import java.util.*;
import java.io.*;

public class Baek1940 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] visited = new boolean[200001];
		boolean[] visited2 = new boolean[200001];
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			visited[num] = true;
			arr[i] = num;
		}
		int answer = 0;
		if (M > 200000) {
			System.out.println(0);
			return;
		}
		visited2[0] = true;
		for (int i = 0; i < N; i++) {
			if (M - arr[i] > 0 && M - arr[i] != arr[i] && visited[M - arr[i]] && !visited2[M - arr[i]]) {
				visited2[arr[i]] = true;
				visited2[M - arr[i]] = true;
				answer++;
			}
		}
		System.out.println(answer);

	}

}
