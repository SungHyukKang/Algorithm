import java.util.*;
import java.io.*;

public class Baek15927 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] X = br.readLine().toCharArray();
		boolean tf = false;
		for (int i = 0; i < X.length / 2; i++) {
			if (X[i] != X[X.length - i - 1]) {
				System.out.println(X.length);
				return;
			} else if (X[i] != X[i + 1]) {
				tf = true;
			}
		}
		if (tf)
			System.out.println(X.length - 1);
		else
			System.out.println("-1");

	}

}
