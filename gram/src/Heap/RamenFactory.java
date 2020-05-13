package Heap;
import java.util.*;
public class RamenFactory {

	public int solution(int stock , int[] dates , int[] supplies ,int k ){
		PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());
		int answer = 0;
		int index =0;
		int index2=0;
		int st= stock;
		while(st<k){
			for(int i = 0 ;i<dates.length;i++){
				if(dates[i]<=st){
					pq.offer(supplies[i]);
					index2=i;
				}
			}
			index =index2+1;
			st+=pq.poll();
			answer++;
		}
		
		System.out.println(answer);
		return 0;
	}
		
	
	public static void main(String[] args) {
		RamenFactory rf = new RamenFactory();
		rf.solution(10, new int[]{5,10}, new int[]{1,100},100);
		
	}

}
