package Greedy;
import java.util.*;
public class ConnectingIsland {
	
	public int solution(int n , int[][] costs){
		int answer= 0;
		int[][] newcosts =new int[costs.length*2][3];
		for(int i =0;i<costs.length*2;i++){
			for(int j =0;j<3;j++){
				if(i>=costs.length){
					newcosts[i][1]=costs[i%5][0];
					newcosts[i][0]=costs[i%5][1];
					newcosts[i][2]=costs[i%5][2];
				}else
					newcosts[i][j]=costs[i][j];
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		ConnectingIsland ci = new ConnectingIsland();
		ci.solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
		
		
	}
}
