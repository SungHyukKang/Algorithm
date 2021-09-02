import java.util.*;
import java.io.*;

public class Baek1747 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[10000001];
		ArrayList<Integer> list = new ArrayList<>();
		visited[1] = true;
		for (int i = 2; i <= Math.sqrt(10000000); i++) {
			if (visited[i])
				continue;
			for (int j = i * i; j <= 10000000; j += i) {
				visited[j] = true;
			}
		}
		int cnt = 1;
		for (int i = N; i <= 10000000; i++) {
			if (!visited[i])
				list.add(i);
		}
		for (int num : list) {
			char[] numToChar = String.valueOf(num).toCharArray();
			boolean tf = true;
			for (int i = 0; i < numToChar.length / 2; i++) {
				if (numToChar[i] != numToChar[numToChar.length - 1 - i]) {
					tf = false;
					break;
				}
			}
			if (tf) {
				System.out.println(num);
				break;
			}
		}

	}

}
