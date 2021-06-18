import java.util.*;
import java.io.*;

public class Baek2630_2 {
	static int N;
	static int[][] arr;
	static int[] answer = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		func(0, 0, N);
		for (int x : answer)
			System.out.println(x);

	}

	public static void func(int x, int y, int N) {
		if (isPossible(x, y, N)) {
			if (arr[x][y] == 0) {
				answer[0]++;
			} else {
				answer[1]++;
			}
		} else {
			int size = N / 2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					func(x + i * size, y + j * size, size);
				}
			}
		}
	}

	public static boolean isPossible(int x, int y, int N) {
		int num = arr[x][y];
		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
				if (arr[i][j] != num) {
					return false;
				}
			}
		}
		return true;
	}

}
