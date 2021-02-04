import java.util.*;
import java.io.*;

public class Baek1992 {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String X = br.readLine();
			for (int j = 0; j < X.length(); j++) {
				arr[i][j] = X.charAt(j) - '0';
			}
		}
		divide(0, 0, N);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean isPossible(int r, int c, int N) {
		int start = arr[r][c];
		for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (arr[i][j] != start) {
					return false;
				}
			}
		}
		return true;
	}

	public static void divide(int r, int c, int N) {
		if (isPossible(r, c, N)) {
			sb.append(arr[r][c]);
		} else {
			int size = N / 2;
			sb.append("(");
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					divide(r + i * size, c + j * size, size);
				}
			}
			sb.append(")");
		}
	}

}
