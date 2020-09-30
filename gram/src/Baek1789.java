import java.util.*;
public class Baek1789 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long S = sc.nextInt();
		
		long left = 1;
		long right =S;
		long answer=0;
		while(left<=right) {
			long mid = (left+right)/2;
			if(mid*(mid+1)/2<=S) {
				answer=mid;
				left=mid+1;
			}else
				right=mid-1;
		}
		System.out.println(answer);
	}

}
