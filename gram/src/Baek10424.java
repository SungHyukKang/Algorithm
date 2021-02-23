import java.util.*;
import java.io.*;

public class Baek10424 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[x] = i;
		}
		for (int i = 1; i <= N; i++) {
			sb.append(i - arr[i] + "\n");
		}

		System.out.println(sb.toString());
	}

}
