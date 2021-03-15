import java.util.*;
import java.io.*;

public class Baek2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int min = Math.min(A, B);
		int max = Math.max(A, B);

		System.out.println(gcd(max, min));
		System.out.println(lcm(max, min));

	}

	public static int gcd(int big, int small) {
		if (big % small == 0)
			return small;
		return gcd(small, big % small);
	}

	public static int lcm(int big, int small) {
		return (big * small) / gcd(big, small);
	}

}
