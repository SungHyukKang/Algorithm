package gram;

import java.util.*;


public class Rectangle {

	public int[] solution(int[][] v){
		
		HashMap<Integer,Integer> hsmapX = new HashMap<>();
		HashMap<Integer,Integer> hsmapY = new HashMap<>();
		for(int i =0;i<v.length;i++) {
			hsmapX.put(v[i][0],hsmapX.getOrDefault(v[i][0], 0)+1);
			hsmapY.put(v[i][1],hsmapY.getOrDefault(v[i][1], 0)+1);
		}
		int[] answer = new int[2];
		for(int X : hsmapX.keySet()) {
			if(hsmapX.get(X)==1) {
				answer[0]=X;
				break;
			}
		}
		for(int Y : hsmapY.keySet()) {
			if(hsmapY.get(Y)==1) {
				answer[1]=Y;
				break;
			}
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		Rectangle rc = new Rectangle();
		rc.solution(new int[][]{{1,2},{2,2},{1,1}});	

	}

}
