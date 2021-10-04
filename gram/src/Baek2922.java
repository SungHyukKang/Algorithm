import java.util.*;
import java.io.*;

public class Baek2922 {
	static char[] str;

	static long answer = 0;

	public static void main(String[] args) throws IOException {
		str = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		dfs(0, 0, 0, false, 1);
		System.out.println(answer);
	}

	public static void dfs(int depth, int ja, int mo, boolean tf, long sum) {
		if (depth == str.length) {
			if (tf) {
				answer += sum;
			}
			return;
		}
		if (str[depth] == '_') {
			if (ja + 1 < 3) {
				dfs(depth + 1, ja + 1, 0, tf, sum * 20);
				dfs(depth + 1, ja + 1, 0, true, sum);
			}
			if (mo + 1 < 3) {
				dfs(depth + 1, 0, mo + 1, tf, sum * 5);
			}
		} else if (str[depth] == 'A' || str[depth] == 'E' || str[depth] == 'I' || str[depth] == 'O'
				|| str[depth] == 'U') {
			if (mo + 1 >= 3) {
				return;
			}
			dfs(depth + 1, 0, mo + 1, tf, sum);
		} else {
			if (ja + 1 >= 3)
				return;
			if (str[depth] == 'L') {
				tf = true;
			}
			dfs(depth + 1, ja + 1, 0, tf, sum);
		}
	}

//	public static void dfs(int depth, int ja, int mo, boolean tf, long sum) {
//		if (depth == str.length) {
//			if (tf) {
//				answer += sum;
//			}
//			return;
//		}
//		for (int i = depth; i < str.length; i++) {
//			if (str[i] == '_') {
//				if (ja + 1 < 3) {
//					dfs(i + 1, ja + 1, 0, tf, sum * 20);
//					dfs(i + 1, ja + 1, 0, true, sum);
//				}
//				if (mo + 1 < 3)
//					dfs(i + 1, 0, mo + 1, tf, sum * 5);
//				return;
//			} else if (str[i] == 'A' || str[i] == 'E' || str[i] == 'I' || str[i] == 'O' || str[i] == 'U') {
//				ja = 0;
//				mo++;
//				if (mo >= 3) {
//					return;
//				}
//				if (str.length - 1 == i) {
//					dfs(i + 1, ja, mo, tf, sum);
//				}
//			} else {
//				if (str[i] == 'L')
//					tf = true;
//				ja++;
//				mo = 0;
//				if (ja >= 3) {
//					return;
//				}
//				if (str.length - 1 == i) {
//					dfs(i + 1, ja, mo, tf, sum);
//				}
//			}
//		}
//	}
}
