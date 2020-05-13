package KakaoWinterInternShip;

import java.util.*;

public class CrainGame {

	
	public int solution(int[][] board, int[] moves){
		ArrayList<Integer> arr = new ArrayList<>();
			for(int i =0 ;i<moves.length;i++){				
				for(int j =0;j<board.length;j++){
					if(board[j][moves[i]-1]!=0){
						arr.add(board[j][moves[i]-1]);
						board[j][moves[i]-1]=0;
						break;
					}
				}
			}
		int size = arr.size();
		int answer=0;
		for(int i=0;i<size-1;i++){
			System.out.println("»Ì±â Àü");
			System.out.println(arr);
			if(arr.get(i)==arr.get(i+1)){
				arr.remove(i);
				arr.remove(i);
				answer=answer+2;
				i=-1;
				size=arr.size();
			}
			System.out.println("»Ì±â ÈÄ");
			System.out.println(arr);
			
		}
		
		return answer;
	
	}
	public static void main(String[] args) {
		CrainGame cg = new CrainGame();
		cg.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},new int[]{1,1,5,4});
		

	}

}
