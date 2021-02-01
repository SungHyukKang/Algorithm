import java.util.*;
import java.io.*;

class Pair11657 {
	int e;
	int d;

	public Pair11657(int e, int d) {
		this.e = e;
		this.d = d;
	}

}

public class Baek11657 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<ArrayList<Pair11657>> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] D = new long[N + 1];
		long INF = Long.MAX_VALUE;
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			D[i] = INF;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.get(s).add(new Pair11657(e, d));
		}
		boolean tf = true;
		D[1] = 0;
		for (int i = 1; i <= N; i++) {
			if (!tf)
				break;
			for (int j = 1; j <= N; j++) {
				for (Pair11657 p : list.get(j)) {
					if (D[j] != INF && D[p.e] > D[j] + p.d) {
						D[p.e] = D[j] + p.d;
						if (i == N)
							tf = false;
					}
				}
			}
		}
		if (tf) {
			for (int i = 2; i <= N; i++) {
				bw.write(D[i] == INF ? "-1\n" : D[i] + "\n");
			}
		} else {
			bw.write("-1");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
