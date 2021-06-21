import java.util.*;
import java.io.*;

public class Baek15881 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String X = br.readLine();
		int size = X.length();
		int answer = 0;
		for (int i = 0; i < N - 3; i++) {
			if (X.substring(i, i + 4).equals("pPAp")) {
				i = i + 3;
				answer++;
			}
		}
		System.out.println(answer);
	}

}
