import java.util.*;
import java.io.*;

public class Baek2564 {
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ArrayList<int[]> dirList = new ArrayList<>();
		int store = Integer.parseInt(br.readLine());
		for (int i = 0; i < store; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			dirList.add(dir(d, num));
		}
		st = new StringTokenizer(br.readLine());
		int dgd = Integer.parseInt(st.nextToken());
		int dgNum = Integer.parseInt(st.nextToken());
		int[] dg = dir(dgd, dgNum);
		int ans = 0;
		int temp = 0;
		if (dgd == 1) {
			temp = 2;
		} else if (dgd == 2) {
			temp = 1;
		} else if (dgd == 3) {
			temp = 4;
		} else {
			temp = 3;
		}

		for (int[] arr : dirList) {
			int dir = arr[2];
			if (dir == temp) {
				if (dir == 1 || dir == 2) {
					ans += Math.min(M + N - dg[0] + N - arr[0], M + dg[0] + arr[0]);
				} else {
					ans += Math.min(N + dg[1] + arr[1], N + M - dg[1] + M - arr[1]);
				}
			} else {
				ans += Math.abs(dg[0] - arr[0]) + Math.abs(dg[1] - arr[1]);
			}

		}
		System.out.println(ans);
	}

	public static int[] dir(int d, int num) {
		if (d == 1) {
			return new int[] { num, 0, d };
		} else if (d == 2) {
			return new int[] { num, M, d };
		} else if (d == 3) {
			return new int[] { 0, num, d };
		} else {
			return new int[] { N, num, d };
		}
	}

}
