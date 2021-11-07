import java.util.*;
import java.io.*;

public class Baek1673 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String X = "";
		StringBuilder sb = new StringBuilder();
		while ((X = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(X);
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int coupon = n;
			int answer = n;
			while (coupon >= k) {
				int chicken = coupon / k;
				answer += chicken;
				coupon = chicken + coupon % k;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);

	}

}
