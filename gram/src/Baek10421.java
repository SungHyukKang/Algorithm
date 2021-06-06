import java.util.*;
import java.io.*;

public class Baek10421 {

	static int N1;
	static int N2;
	static int[] arr;
	static int[] arr2;
	static Stack<Integer> stack = new Stack<>();
	static boolean[] visited = new boolean[10];
	static int cnt = 0;

	
	public static int stoi(String x) {
		return Integer.parseInt(x);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N1 = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		arr = new int[N1];
		for (int i = 0; i < N1; i++) {
			arr[i] = stoi(st.nextToken());
		}
		boolean tf = false;
		try {
			N2 = stoi(br.readLine());
		} catch (Exception e) {
			N2 = stoi(st.nextToken());
			arr2 = new int[N2];
			for (int i = 0; i < N2; i++) {
				arr2[i] = stoi(st.nextToken());
				visited[arr2[i]] = true;
				tf = true;
			}
		}
		if (!tf) {
			arr2 = new int[N2];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N2; i++) {
				arr2[i] = stoi(st.nextToken());
				visited[arr2[i]] = true;
			}
		}
		dfs(0);
		System.out.println(cnt);
	}

	public static void dfs(int idx) {
		if (idx == arr[0] + arr[1]) {
			StringBuilder sb = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();

			for (int i = 0; i < stack.size(); i++) {
				if (i < arr[0]) {
					sb.append(stack.get(i));
				} else {
					sb2.append(stack.get(i));
				}
			}

			String x = String.valueOf(stoi(sb.toString()) * stoi(sb2.toString()));
			for (int i = 0; i < x.length(); i++) {
				if (!visited[x.charAt(i) - '0'])
					return;
			}
			int jari = 2;
			for (int i = sb2.length() - 1; i >= 0; i--) {
				int num1 = sb2.charAt(i) - '0';
				int cnt = 0;
				for (int j = sb.length() - 1; j >= 0; j--) {
					int num2 = sb.charAt(j) - '0';
					int gob = num1 * num2 + cnt;
					cnt = 0;
					String gtos = String.valueOf(gob);
					if (!visited[gtos.charAt(gtos.length() - 1) - '0']) {
						return;
					}
					if (gob >= 10) {
						cnt = (gtos.charAt(0) - '0');
					}
				}
				String Z = String.valueOf(num1 * stoi(sb.toString()));
				for (int z = 0; z < Z.length(); z++) {
					if (!visited[Z.charAt(z) - '0'])
						return;
				}
				if (Z.length() != arr[jari++]) {
					return;
				}
			}
			cnt++;

			return;
		}

		for (int i = 0; i < N2; i++) {
			stack.push(arr2[i]);
			dfs(idx + 1);
			stack.pop();
		}
	}

}
