import java.util.*;

public class 디스크컨트롤러 {
	public static int solution(int[][] jobs) {
		int answer = 0;
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] <= o2[0] ? -1 : 1;
			}
		});
		for (int[] job : jobs) {
			for (int x : job) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		
		
		
		return answer;
	}

	public static void main(String[] args) {
		solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } });
	}

}
