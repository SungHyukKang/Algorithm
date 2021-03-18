import java.util.*;
import java.io.*;

public class Baek11054 {
	static int N;
	static int[] arr;
	static int[] dpu;
	static int[] dpd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[N] = -1;
		dpu = new int[N];
		dpd = new int[N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dpu, -1);
			Arrays.fill(dpd, -1);
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dfsd(i) + dfsu(i) - 1);
		}
		System.out.println(max);
	}

	public static int dfsd(int z) {
		if (dpd[z] != -1)
			return dpd[z];

		dpd[z] = 0;

		for (int i = 0; i < z; i++) {
			if (arr[i] < arr[z]) {
				dpd[z] = Math.max(dpd[z], dfsd(i) + 1);
			}
		}
		return dpd[z];
	}

	public static int dfsu(int z) {
		if (z == N)
			return 1;
		if (dpu[z] != -1)
			return dpu[z];

		dpu[z] = 0;

		for (int i = z + 1; i <= N; i++) {
			if (arr[i] < arr[z]) {
				dpu[z] = Math.max(dpu[z], dfsu(i) + 1);
			}
		}

		return dpu[z];
	}

}
