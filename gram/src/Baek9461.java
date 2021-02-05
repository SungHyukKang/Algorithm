import java.io.*;

public class Baek9461 {

	public static void main(String[] args) throws IOException {
		long[] arr = new long[101];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		for (int i = 3; i <= 100; i++) {
			arr[i] = arr[i - 2] + arr[i - 3];
		}
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(arr[N] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
