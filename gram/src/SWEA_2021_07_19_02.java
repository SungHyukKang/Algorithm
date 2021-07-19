import java.util.*;
import java.io.*;

class SWEA_2021_07_19_02 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int Nval = (1 << N) - 1;
			sb.append("#" + test_case + " " + ((Nval & M) == Nval ? "ON" : "OFF") + "\n");

		}
		System.out.println(sb);
	}
}