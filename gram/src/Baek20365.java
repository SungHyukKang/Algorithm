import java.util.*;
import java.io.*;

public class Baek20365 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		char[] str = br.readLine().toCharArray();

		int bCnt = 0;
		int rCnt = 0;
		for (int i = 1; i < str.length; i++) {
			if (str[i] == str[i - 1]) {
				if (i == str.length - 1) {
					if (str[i] == 'R')
						rCnt++;
					else
						bCnt++;
				}
				continue;
			} else {
				if (str[i] == 'B') {
					rCnt++;
				} else {
					bCnt++;
				}
				if (i == str.length - 1) {
					if (str[i] == 'B') {
						bCnt++;
					} else
						rCnt++;
				}
			}
		}
		System.out.println(Math.min(rCnt, bCnt) + 1);
	}

}
