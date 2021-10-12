import java.util.*;
import java.io.*;

public class Baek5464 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] parking = new int[N + 1];
		int[] cars = new int[M + 1];
		int[] holding = new int[M + 1];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			parking[i] = Integer.parseInt(br.readLine());
			pq.offer(i);
		}
		for (int i = 1; i <= M; i++) {
			cars[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		// q : 대기중인 차
		// pq : 현재 주차할 수 있는 공간
		for (int i = 0; i < 2 * M; i++) {
			int car = Integer.parseInt(br.readLine());
			if (car < 0) {
				int holdingPark = holding[-car];
				pq.offer(holdingPark);
				holding[-car] = 0;
				if (!q.isEmpty()) {
					int waitCar = q.poll();
					int park = pq.poll();
					holding[waitCar] = park;
					answer += parking[park] * cars[waitCar];
				}
			} else {
				if (pq.isEmpty()) {
					q.offer(car);
					continue;
				}
				if (q.isEmpty()) {
					int park = pq.poll();
					holding[car] = park;
					answer += parking[park] * cars[car];
				} else {
					int waitCar = q.poll();
					int park = pq.poll();
					holding[waitCar] = park;
					answer += parking[park] * cars[waitCar];
				}
			}
		}
		System.out.println(answer);
	}

}
