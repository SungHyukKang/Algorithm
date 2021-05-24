import java.util.*;
import java.io.*;

public class Baek21771 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int RG = Integer.parseInt(st.nextToken());
		int CG = Integer.parseInt(st.nextToken());
		int RP = Integer.parseInt(st.nextToken());
		int CP = Integer.parseInt(st.nextToken());

		int cnt = 0;
		int PCNT = RP * CP;
		for (int i = 0; i < R; i++) {
			char[] x = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (x[j] == 'P') {
					cnt++;
				}
			}
		}
		if (cnt == PCNT) {
			System.out.println("0");
		} else
			System.out.println("1");
	}

}
