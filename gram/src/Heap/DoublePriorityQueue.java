package Heap;

import java.util.ArrayList;
import java.util.Collections;

public class DoublePriorityQueue {
	public int[] solution(String[] operations){		
		LinkedList ll =new LinkedList();
		for(String X : operations){
			ll.add(X.split(" ")[0], Integer.parseInt(X.split(" ")[1]));
		}
		int[] answer =new int[2];
		
		if(ll.arr.isEmpty())
			return new int[]{0,0};
		else{
			answer[0]=ll.arr.get(0);
			answer[1]=ll.arr.get(ll.arr.size()-1);
		}
		return answer;
	}
	public static void main(String[] args){
		DoublePriorityQueue dpq = new DoublePriorityQueue();
		dpq.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
	}	
	
	class LinkedList{
		ArrayList<Integer> arr = new ArrayList<>();
		
		LinkedList add(String input , Integer num){
			if(input.equals("I")){
				arr.add(num);
				Collections.sort(arr,Collections.reverseOrder());
			}else{
				if(arr.isEmpty()){
					return this;
				}
				if(num==1){
					arr.remove(0);
				}else{
					arr.remove(arr.size()-1);
				}
			}
			return this;
		}
		
	}	
}
