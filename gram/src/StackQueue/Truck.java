package StackQueue;

import java.util.*;

public class Truck {
	public int solution(int bridge_length, int weight , int[] truck_weights){
		int answer = 0;
		
		Queue<Integer> q = new LinkedList<>();
		int sum=0;
		
		for(int x : truck_weights) {
			while(true) {
				if(q.isEmpty()) {
					q.offer(x);
					sum+=x;
					answer++;
					break;
				}else if(q.size()==bridge_length) {
					sum-=q.poll();
				}else {
					if(sum+x>weight) {
						q.offer(0);
						answer++;
					}else {
						q.offer(x);
						sum+=x;
						answer++;
						break;
					}
				}
			}
		}
		
		return answer+bridge_length;
	}

	public static void main(String[] args) {
		Truck truck = new Truck();

		truck.solution(2, 10, new int[] { 7, 4, 5, 6 });

	}

}