package KAKAO2020InternShip;
import java.util.*;
class Pair{
	int x, y;
	Pair (int x, int y){
		this.x=x;
		this.y=y;
	}
}
 
public class PushedKeypad {
	public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        Pair lHand = new Pair(3,0);
        Pair rHand = new Pair(3,2);
        for(int Z : numbers) {
        	queue.offer(Z);
        }//7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2
        while(!queue.isEmpty()) {
        	int num = queue.poll();
        	int num2 = num-1;
        	if(num==0) {
        		num2=10;
        	}
        	Pair pre = new Pair(num2/3,num2%3);
        	if(num%3==1) {
        		sb.append("L");
        		lHand = new Pair(num2/3,num2%3);
        	}else if(num%3==0&&num!=0) {
        		sb.append("R");
        		rHand= new Pair(num2/3,num2%3);
        	}else {
        		System.out.println("P : " + pre);
        		int L = Math.abs(pre.x-lHand.x)+Math.abs(pre.y-lHand.y);
        		int R = Math.abs(pre.x-rHand.x)+Math.abs(pre.y-rHand.y);
        		if(L==R) {
        			if(hand.equals("left")) {
        				sb.append("L");
        				lHand=new Pair(num2/3,num2%3);
        			}else {
        				sb.append("R");
        				rHand=new Pair(num2/3,num2%3);
        			}
        		}else if(L<R) {
        			sb.append("L");
        			lHand=new Pair(num2/3,num2%3);
        		}else {
        			sb.append("R");
        			rHand=new Pair(num2/3,num2%3);
        		}
        		}
        	}
        	
        return sb.toString();
    }
	
	public static void main(String[] args) {
		PushedKeypad pk = new PushedKeypad();
		System.out.println(pk.solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
	}
}