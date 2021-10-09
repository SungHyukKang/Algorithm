import java.util.*;
import java.io.*;

public class Baek1411 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			char[] ch = arr[i].toCharArray();
			for (int j = i + 1; j < N; j++) {
				char[] ch2 = arr[j].toCharArray();
				int[] visit = new int[26];
				int[] visit2 = new int[26];
				boolean tf = true;
				for (int z = 0; z < ch.length; z++) {
					if (visit[ch[z] - 'a'] == visit2[ch2[z] - 'a']) {
						visit[ch[z] - 'a'] = z + 1;
						visit2[ch2[z] - 'a'] = z + 1;
					} else {
						tf = false;
						break;
					}
				}
				if (tf) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}
