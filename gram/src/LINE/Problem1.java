package LINE;

import java.util.*;
public class Problem1 {

	public int solution(int[][] boxes) {
        int answer = -1;
        HashMap<Integer , Integer> hsmap = new HashMap<>();
        
        for(int i =0;i<boxes.length;i++){
        	for(int j =0;j<boxes[i].length;j++) {
        		hsmap.put(boxes[i][j],hsmap.getOrDefault(boxes[i][j], 0)+1);
        	}
        }
        int cnt = 0;
        for(int X : hsmap.keySet()) {
        	if(hsmap.get(X)!=2) {
        		cnt++;
        	}
        }
        answer=cnt;
        
        System.out.println(answer/2);
        
        return answer/2;
    }
	
	public static void main(String[] args) {
		Problem1 pb= new Problem1();
		pb.solution(new int[][] {{1,2},{3,4},{1,2},{1,1},{1,4},{5,6}});
	}

}
