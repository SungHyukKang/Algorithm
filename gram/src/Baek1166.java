import java.util.*;
import java.io.*;

public class Baek1166 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		double L = Double.parseDouble(st.nextToken());
		double W = Double.parseDouble(st.nextToken());
		double H = Double.parseDouble(st.nextToken());
		double s = 1;
		double e = Math.max(L, Math.max(W, H));
		double answer = 0;
		HashSet<Double> hsset = new HashSet<>();
		while (true) {
			double mid = (s + e) / 2;
			if (hsset.contains(mid))
				break;
			double l = Math.floor(L / mid);
			double w = Math.floor(W / mid);
			double h = Math.floor(H / mid);
			double ans = l * w * h;
			hsset.add(mid);
			if (ans >= N) {
				answer = Math.max(answer, mid);
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		System.out.println(answer);
	}

}
