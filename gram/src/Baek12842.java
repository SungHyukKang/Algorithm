import java.util.*;
import java.io.*;

public class Baek12842 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int remain = N - S;
		int cnt = 0;
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		for (int i = 0; i < M; i++)
			arr[i] = Integer.parseInt(br.readLine());
		for (int i = 0; i < 100000; i++) {
			for (int j = 0; j < M; j++) {
				if (i % arr[j] == 0)
					cnt++;
				if (cnt == remain) {
					System.out.println(j + 1);
					break;
				}
			}
		}

	}

}
