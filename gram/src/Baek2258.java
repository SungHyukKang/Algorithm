import java.util.*;
import java.io.*;

class Pair2258 {
	int w, v;

	public Pair2258(int w, int v) {
		this.w = w;
		this.v = v;
	}

}

public class Baek2258 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int INF = Integer.MAX_VALUE;
		int min = INF;
		ArrayList<Pair2258> p = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			p.add(new Pair2258(w, v));
		}

		Collections.sort(p, new Comparator<Pair2258>() {
			@Override
			public int compare(Pair2258 arg0, Pair2258 arg1) {
				if (arg0.v < arg1.v) {
					return -1;
				} else if (arg0.v == arg1.v) {
					return -Integer.compare(arg0.w, arg1.w);
				} else {
					return 1;
				}
			}
		});
		int pre = 0;
		int val = 0;
		int sum = 0;
		boolean tf = false;
		for (int i = 0; i < N; i++) {
			Pair2258 p2 = p.get(i);
			int w = p2.w;
			int v = p2.v;
			if (pre == v) {
				val += p2.v;
			} else {
				val = p2.v;
			}
			sum += w;
			pre = p2.v;
			if (sum >= M) {
				tf = true;
				min = Math.min(val, min);
			}
		}
		System.out.println(!tf ? "-1" : min);
	}

}
