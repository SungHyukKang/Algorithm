package ElevenST;
import java.util.*;
public class FindPair {
	public static int solution(int[] A) {
		HashMap<Integer,Integer> hsmap =new HashMap<>();
		for(int i =0;i<A.length;i++) {
			hsmap.put(A[i],hsmap.getOrDefault(A[i], 0)+1);
		}
		System.out.println(hsmap);
		for(int X : hsmap.keySet()) {
			if(hsmap.get(X)%2!=0) {
				return X;
			}
		}
		return 0;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[]{9,3,9,3,9,7,9}));
	}

}
