import java.util.*;
import java.io.*;

public class Baek10610 {

	public static void main(String[] args) throws IOException {
		char[] numStr = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		int[] arr = new int[numStr.length];
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = numStr[i] - '0';
		}
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		if (sum % 3 != 0) {
			System.out.println("-1");
			return;
		}

		Arrays.sort(arr);
		boolean tf = false;
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == 0) {
				tf = true;
			}
			sb.append(arr[i]);
		}
		if (tf)
			System.out.println(sb);
		else
			System.out.println(-1);
	}

}
