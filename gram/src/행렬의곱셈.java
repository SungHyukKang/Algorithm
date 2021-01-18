
public class 행렬의곱셈 {
	public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i =0 ;i <arr1.length;i++) {
        	for(int j =0;j<arr2[0].length;j++) {
        		int sum=0;
        		for(int z=0;z<arr1[j].length;z++) {
        			sum+=arr1[i][z]*arr2[z][j];
        		}
        		answer[i][j]=sum;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}} , new int[][] {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}});
	}

}
