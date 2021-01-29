package DynamicProgramming;
public class TheLargestSquare {
	public static int solution(int[][] board) {
		int answer = 1234;
		int[][] map = new int[board.length][board[1].length];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]!=0) {
					if(i+1<board.length&&j+1<board[i].length) {
						map[i][j]=Math.min(Math.min(board[i+1][j],board[i+1][j+1]),board[i][j+1])+1;
						System.out.println(map[i][j]);
					}
				}
			}
		}
		return answer;
	}
	
	
	
	public static void main(String[] args) {
		solution(new int[][] {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}});
	}

}
