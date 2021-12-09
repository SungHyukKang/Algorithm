import java.io.*;

public class Baek4134 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			for (long k = num;; k++) {
				boolean tf = true;
				for (int j = 2; j <= Math.sqrt(k); j++) {
					if (k % j == 0) {
						tf = false;
						break;
					}
				}
				if (k == 0 || k == 1)
					continue;
				if (tf) {
					sb.append(k).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
