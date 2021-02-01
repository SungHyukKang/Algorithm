import java.util.*;
import java.io.*;

class Pair16953 {
	String data;
	long cnt;

	public Pair16953(String data, long cnt) {
		this.data = data;
		this.cnt = cnt;
	}

}

public class Baek16953 {
	static Queue<Pair16953> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		q.offer(new Pair16953(String.valueOf(A), 1));

		while (!q.isEmpty()) {
			Pair16953 p = q.poll();
			long data = Long.parseLong(p.data);
			long cnt = p.cnt;
			StringBuilder sb = new StringBuilder();

			if (data == B) {
				System.out.println(cnt);
				return;
			} else if (data > B) {
				continue;
			}
			q.offer(new Pair16953(String.valueOf(data * 2), cnt + 1));
			sb.append(data + "1");
			q.offer(new Pair16953(sb.toString(), cnt + 1));
		}
		System.out.println("-1");
	}

}
