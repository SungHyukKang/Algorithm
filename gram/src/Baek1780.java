import java.util.*;
import java.io.*;

public class Baek1780 {
	static int[][] arr;
	static int[] answer = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(0, 0, N);
		for (int x : answer)
			System.out.println(x);
	}

	public static void divide(int row, int col, int N) {
		if (isPossible(row, col, N)) {
			if (arr[row][col] == -1) {
				answer[0]++;
			} else if (arr[row][col] == 0)
				answer[1]++;
			else
				answer[2]++;
		} else {
			int size = N / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					divide(row + size * i, col + size * j, size);
				}
			}
		}
	}

	public static boolean isPossible(int row, int col, int N) {
		int s = arr[row][col];
		for (int i = row; i < row + N; i++) {
			for (int j = col; j < col + N; j++) {
				if (s != arr[i][j])
					return false;
			}
		}
		return true;
	}
}
