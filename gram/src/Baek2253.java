import java.util.*;
import java.io.*;

public class Baek2253 {
	static int N;
	static int M;
	static int[] arr;
	static int[] dp;
	static int[] move = { 1, 0, -1 };
	static int answer = 210000000;
	static int INF = 21000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		dp = new int[N + 1];
		for (int i = 0; i < M; i++) {
			arr[Integer.parseInt(br.readLine())] = -1;
		}
		System.out.println(dfs(1, 1));
	}

	static int dfs(int m, int x) {
		System.out.println(x+" " +m);
		print();
		if (x == N) {
			return 0;
		}
		if (dp[x] != 0) {
			return dp[x];
		}
		dp[x]=INF;
		for (int i = 0; i < move.length; i++) {
			int mm = move[i] + m;
			if (mm >= 1) {
				int nx = x + mm;
				if ( nx <= N&&arr[nx] != -1 )
					dp[x] = Math.min(dp[x], 1+dfs(mm, nx));
			}
		}
		return dp[x];
	}

	public static void print() {
		for (int i = 1; i <= N; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		System.out.println("----------------------");
	}
}
