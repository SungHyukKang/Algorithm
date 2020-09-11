package StackQueue;

public class Top {

	public int[] solution(int[] heights){		
		int[] answer = new int[heights.length];
		int[] heights2 =new int[heights.length];
		int j = 0;
		
		for(int i = heights.length-1; i>=0;i--,j++){
			heights2[j]=heights[i];
		}
		for(int x = 0 ;x<heights.length;x++){
			for(int y = x+1;y<heights.length;y++){
				if(heights2[x]<heights2[y]){
					answer[heights.length-1-x]=heights.length-y;
					break;
				}
			}
		}
		for(int b : answer){
			System.out.println(b);
		}
		return answer;
		
	}
	public static void main(String[] args) {
		Top top = new Top();
		top.solution(new int[]{6,9,5,7,4});
	}
}
