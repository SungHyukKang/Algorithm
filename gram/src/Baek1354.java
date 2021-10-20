import java.util.*;
import java.io.*;

public class Baek1354 {
	static HashMap<Long, Long> hashMap = new HashMap<>();
	static long N;
	static int P, Q, X, Y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		System.out.println(dfs(N));
	}

	public static long dfs(long i) {
		if (i <= 0)
			return 1;
		if (hashMap.get(i) != null) {
			return hashMap.get(i);
		}
		hashMap.put(i, dfs(i / P - X) + dfs(i / Q - Y));
		return hashMap.get(i);
	}

}
