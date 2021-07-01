import java.io.*;

public class Baek4375 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String X;
		StringBuilder ans = new StringBuilder();
		while ((X = br.readLine()) != null) {
			int one = 1;
			int cnt = 1;
			int num = Integer.parseInt(X);
			while (true) {
				if (one % num == 0)
					break;
				one = (one * 10 + 1) % num;
				cnt++;
			}
			ans.append(cnt + "\n");
		}
		System.out.println(ans);
	}
}
