import java.util.*;
import java.io.*;

public class Baek18111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> hsmap = new HashMap<>();

		int[][] arr = new int[N][M];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				hsmap.put(arr[i][j], hsmap.getOrDefault(arr[i][j], 0) + 1); // 같은 높이의 블럭들의 개수를 (key:높이 value:;개수) 쌍으로 맵에
																			// 저장
			}
		}
		int min = 987654321;
		int hei = 0;
		int mmmax = 0;
		int mmmin = 987654321;
		for (int X : hsmap.keySet()) {
			mmmax = Math.max(X, mmmax);
			mmmin = Math.min(X, mmmin);
		}
		for (int X = mmmin; X <= mmmax; X++) { // 키 값을 하나씩 빼서 어떤 높이의 블럭을 하나 지정
			int sum = 0;
			int copyB = B;
			for (int C : hsmap.keySet()) {
				if (X < C) { // 문제의 1번 조건 , 블럭을 부시는 경우
					sum += (C - X) * hsmap.get(C) * 2;
					copyB += (C - X) * hsmap.get(C);
				} else if (X > C) {// 문제의 2번 조건 , 블럭을 쌓는 경우
					sum += (X - C) * hsmap.get(C);
					copyB -= (X - C) * hsmap.get(C);
				} else
					continue;
			}
			if (min >= sum && copyB >= 0) {
				min = sum;
				hei = Math.max(hei, X);
			}
		}
		System.out.println(min + " " + hei);
	}
}
