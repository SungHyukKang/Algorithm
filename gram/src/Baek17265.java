import java.util.*;
import java.io.*;

public class Baek17265 {
	static char[][] map;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static int N;
	static Stack<Character> stack = new Stack<>();
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		stack.push(map[0][0]);
		dfs(0, 0);
		System.out.println(max + " " + min);
	}

	public static void dfs(int x, int y) {
		if (x == N - 1 && y == N - 1) {
			int sum = (stack.get(0) - '0');
			for (int i = 2; i < stack.size(); i += 2) {
				if (stack.get(i - 1) == '*') {
					sum *= (stack.get(i) - '0');
				} else if (stack.get(i - 1) == '+') {
					sum += (stack.get(i) - '0');
				} else {
					sum -= (stack.get(i) - '0');
				}
			}
			if (max < sum)
				max = sum;
			if (min > sum)
				min = sum;
			return;
		}

		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isPossible(nx, ny)) {
				stack.push(map[nx][ny]);
				dfs(nx, ny);
				stack.pop();
			}

		}

	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}

}
