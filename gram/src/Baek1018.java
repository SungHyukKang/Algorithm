import java.util.*;
import java.io.*;

public class Baek1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[][] arr = new String[n][m];
		String[][] W = new String[8][8];
		String[][] B = new String[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					W[i][j] = "W";
					B[i][j] = "B";
				} else {
					W[i][j] = "B";
					B[i][j] = "W";
				}
			}
		}

		for (int i = 0; i < n; i++) {
			int j = 0;
			String X = br.readLine();
			for (String x : X.split("")) {
				arr[i][j] = x;
				j++;
			}
		}
		int cnt = 21000000;
		for (int s = 0; s <= n - 8; s++) {
			for (int z = 0; z <= m - 8; z++) {
				int Bcnt = 0;
				int Wcnt = 0;
				for (int i = s; i - s < 8; i++) {
					for (int j = z; j - z < 8; j++) {
						if (!arr[i][j].equals(W[i - s][j - z])) {
							Wcnt++;
						}
						if (!arr[i][j].equals(B[i - s][j - z])) {
							Bcnt++;
						}

					}
				}
				int x = Math.min(Wcnt, Bcnt);
				cnt = Math.min(cnt, x);
			}

		}
		System.out.println(cnt);
	}

}
