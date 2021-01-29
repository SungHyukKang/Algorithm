import java.util.*;
public class Baek1300 {
	static long N;
	static long k;
	static long result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		k = sc.nextInt();
		long left = 0;
		long right = k;
		System.out.println(biSearch(left,right));
		
	}
	static long biSearch(long left ,long right) {
		long cnt = 0;
		long mid = (left+right)/2;
		if(left>right)
			return result;
		for(int i =1;i<=N;i++) {
			cnt+=Math.min(mid/i, N);
		}
		if(cnt>=k) {
			result=mid;
			return biSearch(left,mid-1);
		}else {
			return biSearch(mid+1,right);
		}
		
	}
}
