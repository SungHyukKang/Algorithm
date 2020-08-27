package KAKAO2020InternShip;

import java.util.*;
public class JewelryShopping {

	
	public int[] solution(String[] gems) {
		int[] answer = new int[2];
		int start=1;
		int length = Integer.MAX_VALUE;
		Queue<String> que = new LinkedList<>();
		HashMap<String,Integer> hsmap = new HashMap<>();
		HashSet<String> hsset=new HashSet<>();
		
		for(String X :gems) {
			hsset.add(X);
		}
		
		for(String X : gems) {
			hsmap.put(X, hsmap.getOrDefault(X, 0)+1);
			
			que.add(X);
			
			while(true) {
				if(hsmap.get(que.peek())>1) {
					hsmap.put(que.peek(), hsmap.get(que.peek())-1);
					que.poll();
					start++;
				}else
					break;
			}
			if(hsmap.size()==hsset.size()&&length>que.size()) {
				length=que.size();
				answer[0]=start;
				answer[1]=start+length-1;
			}
		}
		
        return answer;
    }
	public static void main(String[] args) {
		//O A C O O C O O A C 
		JewelryShopping js = new JewelryShopping();
		js.solution(new String[] {"O","A","T","T","C","A","X","Z","O","A","T","C","X","Z","C","X","Z"});
								 //O , A , T , C , X , Z ,	XYZ,XYZ,XYZ
		//"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
		//"O","A","T","T","C","A","X","Z","O","A","T","C","X","Z","C","X","Z"
	}

}
