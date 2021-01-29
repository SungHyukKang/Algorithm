import java.util.*;
import java.io.*;

public class Baek5624 {
	public static Stack<Integer> stack = new Stack<>();
	public static HashMap<Integer, Boolean> hsmap = new HashMap<>();
	static int cnt = 0;
	public static int[] arr;
	public static int index;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			hsmap.put(arr[i], false);
		}
		for (int i = 0; i < arr.length; i++) {
			index = i;
			cnt = 0;
			dfs(0);
		}
		for (int i = 0; i < arr.length; i++) {
			if (hsmap.get(arr[i]))
				ans++;
		}
		System.out.println(ans);
	}

	public static void dfs(int sum) {
		if (hsmap.get(arr[index]))
			return;
		if (sum > arr[index]) {
			return;
		}
		if (cnt == 3) {
			hsmap.put(sum, true);
			return;
		}
		for (int i = 0; i < index; i++) {
			if (hsmap.get(arr[index]) != null && !hsmap.get(arr[index])) {
				cnt++;
				dfs(sum + arr[i]);
				cnt--;
			}
		}
	}
}