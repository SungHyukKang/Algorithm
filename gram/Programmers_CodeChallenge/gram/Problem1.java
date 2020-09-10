package gram;
import java.util.*;
public class Problem1 {
	public int[] solution(int[] numbers) {
        HashSet<Integer> hsset = new HashSet<>();
        int num1;
        int num2;
        for(int i =0;i<numbers.length;i++) {
        	num1=numbers[i];
        	for(int j =0;j<numbers.length;j++) {
        		if(i==j)
        			continue;
        		num2=numbers[j];
        		hsset.add(num1+num2);
        	}
        }
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        for(int X : hsset) {
        	pq.offer(X);
        }
        int[] answer = new int[pq.size()];
        int x =0;
        while(!pq.isEmpty()) {
        	answer[x]=pq.poll();
        	x++;
        }
        return answer;
    }
	public static void main(String[] args) {
		Problem1 pb = new Problem1();
		pb.solution(new int[] {2,1,3,4,1});
	}

}
