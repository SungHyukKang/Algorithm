import java.util.*;
import java.io.*;

class Pair14575 {
	int x;
	int y;

	public Pair14575(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pair14575 [x=" + x + ", y=" + y + "]";
	}

}

public class Baek14575 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		Pair14575[] arr = new Pair14575[N];
		int min = 0;
		int max = 0;
		int left = 99999999;
		int right = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Pair14575(x, y);
			min += x;
			max += y;
			left = Math.min(left, x);
			right = Math.max(right, y);
		}
		if (min > T || max < T) {
			System.out.println("-1");
			return;
		}

		while (left + 1 != right) {
			int mid = (left + right) / 2;
			int summin = 0;
			int summax = 0;
			System.out.println(left + " " + right);
			for (int i = 0; i < N; i++) {
				if (arr[i].x > mid) {
					summax = 0;
					break;
				}
				summin += arr[i].x;
				summax += Math.min(mid, arr[i].y);
			}
			if (summin <= T && summax >= T) {
				right = mid;
			} else
				left = mid;
		}
		System.out.println(right);
	}
}
