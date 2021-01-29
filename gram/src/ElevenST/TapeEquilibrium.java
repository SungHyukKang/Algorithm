package ElevenST;

public class TapeEquilibrium {
	public static int solution(int[] A) {
		int sum=0;
		if(A.length==2) {
			return Math.abs(A[0]-A[1]);
		}
		for(int i =1 ;i<A.length;i++) {
			sum+=A[i];
		}
		int sum2=A[0];
		
		int min=Math.abs(sum-sum2);
		for(int i =2 ;i<A.length;i++) {
			sum2=sum2+A[i-1];
			sum=sum-A[i-1];
			if(min>Math.abs(sum2-sum)) {
				min=Math.abs(sum2-sum);
			}
		}
		return min;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,1,2,4,3}));
	}

}
