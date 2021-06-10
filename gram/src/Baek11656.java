import java.util.*;
import java.io.*;

public class Baek11656 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String X = br.readLine();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < X.length(); i++) {
			list.add(X.substring(i));
		}
		StringBuilder sb = new StringBuilder();
		Collections.sort(list);

		for (String Z : list) {
			sb.append(Z + "\n");
		}
		System.out.println(sb);
	}
}
