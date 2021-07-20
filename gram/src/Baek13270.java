import java.util.*;
import java.io.*;

public class Baek13270 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dpmax = new int[10001];
		int[] dpmin = new int[10001];
		dpmax[2] = 1;
		dpmax[3] = 2;
		dpmin[2] = 1;
		dpmin[3] = 2;
		for (int i = 4; i <= n; i++) {
			if ((i & 1) == 1) {
				dpmax[i] = Math.max(dpmax[i - 2] + dpmax[2], dpmax[i - 3] + dpmax[3]);
				dpmin[i] = Math.min(dpmin[i - 2] + dpmin[2], dpmin[i - 3] + dpmin[3]);
			} else {
				dpmax[i] = Math.max(dpmax[i - 2] + dpmax[2], dpmax[i / 2] * 2);
				dpmin[i] = Math.min(dpmin[i - 2] + dpmin[2], dpmin[i / 2] * 2);
			}
		}

		System.out.println(dpmin[n] + " " + dpmax[n]);

	}

}
