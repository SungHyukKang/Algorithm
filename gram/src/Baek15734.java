import java.util.*;
import java.io.*;

public class Baek15734 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int min = Math.min(L, R);
		int max = Math.max(L, R);
		if (min == max) {
			L += A / 2;
			R += A / 2;
			System.out.println(L + R);
		} else {
			while (min != max && A > 0) {
				min++;
				A--;
			}
			min += A / 2;
			max += A / 2;
			while (min != max) {
				max--;
			}

			System.out.println(min + max);
		}
	}

}
