package gram;

public class BigSquare {

	public int solution(int[][] board) {
		int max=0;
        int[][] map = new int[board.length+1][board[0].length+1];
        
        for(int i=0;i<board.length;i++){
            for(int j =0 ;j<board[i].length;j++){
                map[i+1][j+1]=board[i][j];
            }
        }
		for(int i =1;i<=board.length;i++) {
			for(int j =1;j<=board[i].length;j++) {
				if(map[i][j]!=0) {
					map[i][j]=Math.min(Math.min(map[i][j-1],map[i-1][j]),map[i-1][j-1])+1;
					max=Math.max(max,map[i][j]);
				}
			}
		}
		return max*max;
	}

	public static void main(String[] args) {
		BigSquare bs = new BigSquare();
		bs.solution(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } });
	}

}
