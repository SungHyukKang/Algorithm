import java.io.*;

public class Baek9625 {

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] A = new int[N + 1];
		int[] B = new int[N + 1];
		A[0] = 1;
		B[0] = 0;
		A[1] = 0;
		B[1] = 1;
		for (int i = 2; i <= N; i++) {
			A[i] = B[i - 1];
			B[i] = B[i - 1] + A[i - 1];
		}

		System.out.println(A[N] + " " + B[N]);
	}

}
