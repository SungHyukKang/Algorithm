import java.util.*;
import java.io.*;

public class Baek1956 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<int[]>> adjlist = new ArrayList<>();
		int[][] D = new int[V + 1][V + 1];
		int INF = 10001;
		for (int i = 0; i <= V; i++) {
			Arrays.fill(D[i], INF);
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			D[s][e] = d;
		}

		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
				}
			}
		}
		int min = 10001;
		for (int i = 1; i <= V; i++) {
			if (D[i][i] != INF) {
				min = Math.min(D[i][i], min);
			}
		}
		System.out.println(min == INF ? -1 : min);
	}

}
