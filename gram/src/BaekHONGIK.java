import java.util.*;
import java.io.*;

public class BaekHONGIK {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		Arrays.sort(arr, (o1, o2) -> o2 - o1);
		int rank = X * N / 100;
		int cnt = 0;
		for (int s : arr) {
			if (s >= Y)
				cnt++;
		}
		System.out.println(rank + " " + cnt);
	}

}
