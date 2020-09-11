package Heap;

import java.util.*;

public class Scoville {
	
	public int solution(int[] scoville , int K){
		Queue<Integer> qu = new PriorityQueue<Integer>();
		int cnt = 0;
		int idx1=0;
		int idx2=0;
		int sum=0;
		boolean tf = true;
		for(int X : scoville){
			if(X!=0)
				tf=false;
			qu.offer(X);
		}		
		if(tf&&K!=0)
			return -1;
		while(qu.size()>1){
			if(qu.peek()>=K){
				return cnt;
			}
			idx1=qu.poll();
			idx2=qu.poll();
			sum=idx1+(idx2*2);
			qu.offer(sum);
			cnt++;
		}
		if(qu.peek()<K){
			return -1;
		}
		return cnt;
	}
	
	public static void main(String[] args){
		Scoville sc = new Scoville();
		System.out.println(sc.solution(new int[]{0,0,0,0,0,0,0,1}, 6));
	}
}
