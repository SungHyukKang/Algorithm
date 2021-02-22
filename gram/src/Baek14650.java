import java.util.*;
import java.io.*;

public class Baek14650 {
	static int N;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(1, 1);
		dfs(1, 2);
		System.out.println(cnt);
	}

	public static void dfs(int depth, int su) {
		if (depth == N) {
			if (su % 3 == 0)
				cnt++;
			return;
		}

		for (int i = 0; i <= 2; i++) {

			dfs(depth + 1, su + i);
		}
	}

}
