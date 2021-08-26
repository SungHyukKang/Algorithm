import java.util.*;
import java.io.*;

public class Baek17829 {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recursive(N);
		System.out.println(map[0][0]);
	}

	public static void recursive(int size) {
		if (size == 1) {
			return;
		}
		for (int i = 0; i < size; i += 2) {
			for (int j = 0; j < size; j += 2) {
				int[] temp = { map[i][j], map[i][j + 1], map[i + 1][j], map[i + 1][j + 1] };
				Arrays.sort(temp);
				map[i / 2][j / 2] = temp[2];
			}
		}
		recursive(size / 2);
	}

}
