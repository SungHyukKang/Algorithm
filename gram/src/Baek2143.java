import java.util.*;
import java.io.*;

public class Baek2143 {
	static int[] A;
	static int[] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int Asize = Integer.parseInt(br.readLine());
		A = new int[Asize];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Asize; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int Bsize = Integer.parseInt(br.readLine());
		B = new int[Bsize];
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, Long> hsmapA = new HashMap<>();
		HashMap<Integer, Long> hsmapB = new HashMap<>();
		for (int i = 0; i < Bsize; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < Asize; i++) {
			int sum = 0;
			for (int j = i; j < Asize; j++) {
				sum += A[j];
				hsmapA.put(sum, hsmapA.getOrDefault(sum, (long) 0) + 1);
			}
		}
		for (int i = 0; i < Bsize; i++) {
			int sum = 0;
			for (int j = i; j < Bsize; j++) {
				sum += B[j];
				hsmapB.put(sum, hsmapB.getOrDefault(sum, (long) 0) + 1);
			}
		}
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		for (int X : hsmapA.keySet()) {
			left.add(X);
		}
		for (int X : hsmapB.keySet()) {
			right.add(X);
		}
		Collections.sort(left);
		Collections.sort(right);
		int idxL = 0;
		int idxR = right.size() - 1;
		long answer = 0;
		while (idxL < left.size() && idxR >= 0) {
			int lv = left.get(idxL);
			int rv = right.get(idxR);
			if (lv + rv == T) {
				answer += hsmapA.get(lv) * hsmapB.get(rv);
				idxL++;
				idxR--;
			} else if (lv + rv > T) {
				idxR--;
			} else
				idxL++;
		}
		System.out.println(answer);
	}

}
