import java.util.*;
import java.io.*;

class Pair1590 {
	int start;
	int gap;
	int cnt;

	public Pair1590(int start, int gap, int cnt) {
		this.start = start;
		this.gap = gap;
		this.cnt = cnt;
	}
}

public class Baek1590 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int min = 2100000000;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int gap = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			int temp = T - start;
			int nBus = temp % gap <= 0 ? (temp / gap) : (temp / gap) + 1;
			if (nBus < 0)
				nBus = 0;
			int arrive = gap * nBus + start;
			if (nBus < cnt) {
				min = Math.min(min, arrive - T);
			}
		}
		if (min == 2100000000)
			System.out.println("-1");
		else
			System.out.println(min);
	}

}
