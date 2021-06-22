import java.io.*;

public class Baek21144 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String X = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(i);
			if (!X.startsWith(sb.toString())) {
				System.out.println(i);
				break;
			}
		}

	}

}
