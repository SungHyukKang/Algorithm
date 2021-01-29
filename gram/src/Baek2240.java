import java.util.*;
import java.io.*;

public class Baek2240 {
	static int[] arr;
	static boolean[] visited;
	static int[][] dp;
	static int N;
	static int W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

	}

}
