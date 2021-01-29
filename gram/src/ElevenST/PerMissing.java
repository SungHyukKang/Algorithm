package ElevenST;

import java.util.Arrays;

public class PerMissing {
	public static int solution(int[] A) {
        if(A.length==0) {
        	return 1;
        }
        Arrays.sort(A);
        int answer=0;
        for(int i =0;i<A.length-1;i++){
            if(A[i]!=i+1){
                answer= i+1;
                break;
            }
        }
        if(answer==0) {
        	return A[A.length-1]+1;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,3,4,5,6,7,8}));
	}
}
