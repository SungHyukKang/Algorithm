package LINE;
import java.util.*;
public class Problem2 {
	public int[] solution(int[] ball, int[] order) {
        LinkedList<Integer> lk = new LinkedList<>();
        LinkedList<Integer> or = new LinkedList<>();
        boolean[] visited = new boolean[ball.length];
        for(int i =0;i<ball.length;i++) {
        	lk.add(ball[i]);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while(!lk.isEmpty()) {
        	for(int i =0;i<order.length;i++) {
        		if(lk.peekLast()==order[i]) {
        			int num = lk.pollLast();
        			arr.add(num);
        			visited[i]=true;
        			break;
        		}else if(lk.peek()==order[i]) {
        			int num2=lk.poll();
        			arr.add(num2);
        			visited[i]=true;
        			break;
        		}
        	}
        }
        int[] answer = new int[arr.size()];
        for(int i =0;i<arr.size();i++) {
        	answer[i]=arr.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		Problem2 pb = new Problem2();
		pb.solution(new int[] {1,2,3,4,5,6},new int[] {6,2,5,1,4,3});
	}

}
