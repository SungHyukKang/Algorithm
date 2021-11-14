import java.util.*;
import java.io.*;

public class Baek11502 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] visited = new boolean[1001];

		for (int i = 2; i <= Math.sqrt(1000); i++) {
			if (visited[i])
				continue;
			for (int j = i * i; j <= 1000; j += i) {
				visited[j] = true;
			}
		}
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int sosu = Integer.parseInt(br.readLine());
			boolean tf = false;
			for (int i = sosu - 4; i >= 2; i--) {
				if (tf)
					break;
				if (!visited[i]) {
					for (int j = sosu - 4; j >= 2; j--) {
						if (tf)
							break;
						if (!visited[j]) {
							for (int k = sosu - 4; k >= 2; k--) {
								if (!visited[k] && i + j + k == sosu) {
									sb.append(k).append(" ").append(j).append(" ").append(i).append("\n");
									tf = true;
									break;
								}
							}
						}
					}
				}
			}
			if (!tf)
				sb.append("0").append("\n");
		}
		System.out.println(sb);
	}

}
