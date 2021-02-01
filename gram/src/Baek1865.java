import java.util.*;
import java.io.*;

class Pair1865 {
	int e;
	int d;

	public Pair1865(int e, int d) {
		this.e = e;
		this.d = d;
	}

}

public class Baek1865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		long INF = 99999999;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			long[] D = new long[N + 1];
			ArrayList<ArrayList<Pair1865>> list = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
				D[i] = INF;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list.get(s).add(new Pair1865(e, d));
				list.get(e).add(new Pair1865(s, d));
			}
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list.get(s).add(new Pair1865(e, -d));
			}
			boolean tf = true;
			for (int i = 1; i <= N; i++) {
				if (!tf)
					break;
				for (int j = 1; j <= N; j++) {
					for (Pair1865 p : list.get(j)) {
						if (D[p.e] > D[j] + p.d) {
							D[p.e] = D[j] + p.d;
							if (i == N)
								tf = false;
						}
					}
				}
			}
			bw.write(!tf ? "YES" : "NO");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
