import java.util.*;
import java.io.*;

public class Baek10830 {
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		int[][] answer = recursion(B);
		print(answer);
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static int[][] recursion(long B) {
		if (B <= 1) {
			return arr;
		}
		int[][] temp = recursion(B / 2);
		int[][] temp2 = new int[N][N];

		for (int i = 0; i < temp2.length; i++) {
			for (int j = 0; j < temp2.length; j++) {
				int num = 0;
				for (int j2 = 0; j2 < temp2.length; j2++) {
					num += temp[i][j2] * temp[j2][j];
				}
				temp2[i][j] = num % 1000;
			}
		}

		if (B % 2 == 1) {
			int[][] temp3 = new int[N][N];
			for (int i = 0; i < temp2.length; i++) {
				for (int j = 0; j < temp2.length; j++) {
					int num = 0;
					for (int j2 = 0; j2 < temp2.length; j2++) {
						num += temp2[i][j2] * arr[j2][j];
					}
					temp3[i][j] = num % 1000;
				}
			}
			temp2 = temp3;
		}
		return temp2;
	}
}
