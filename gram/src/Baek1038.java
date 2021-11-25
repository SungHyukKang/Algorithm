import java.util.*;
import java.io.*;

public class Baek1038 {
	static ArrayList<Long> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dfs(10, "");
		Collections.sort(list);
		try {
			System.out.println(list.get(N));
		} catch (Exception e) {
			System.out.println(-1);
		}
	}

	public static void dfs(int pre, String str) {
		if (!str.equals(""))
			list.add(Long.parseLong(str));
		for (int i = 0; i <= 9; i++) {
			if (pre > i) {
				dfs(i, str + i);
			}
		}
	}

}
