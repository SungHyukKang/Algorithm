package ElevenST;
import java.util.*;
public class RotationArray {
	public static int[] solution(int[] A, int K) {
		LinkedList<Integer> stack = new LinkedList<>();
		for(int i =0;i<A.length;i++) {
			stack.add(A[i]);
		}
		for(int i =0;i<K;i++) {
			int num =stack.pollLast();
			stack.addFirst(num);
		}
		for(int i = 0;i<A.length;i++) {
			A[i]=stack.pollFirst();
		}
		return A;
    }
	public static void main(String[] args) {
		solution(new int[] {3,8,9,7,6},3);
	}

}
