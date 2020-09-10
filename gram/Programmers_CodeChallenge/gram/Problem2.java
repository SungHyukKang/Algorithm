package gram;

public class Problem2 {
	public int[] solution(int n) {
        int arr[][] = new int[n][n];
		int x = -1, y = -1;
		int num = 1; 
		int size = 0;
		for(int i =1;i<=n;i++) {
			size+=i;
		}
		int[] answer = new int[size];
		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n; ++j) {
				if (i % 3 == 0) {
					x++; 
					y++;
				} else if (i % 3 == 1) {
					y--;
				} else if (i % 3 == 2) {
					x--;
				}
				arr[x][y] = num++;
			}
		}
		int c = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j >= 0; --j) { 
				answer[c++]=arr[i][j];
			}
		}
		return answer;
    }
	public static void main(String[] args) {
		Problem2 pb = new Problem2();
		pb.solution(4);
	}

}
