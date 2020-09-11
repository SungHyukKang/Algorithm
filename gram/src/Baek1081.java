import java.math.BigInteger;
import java.util.Scanner;
public class Baek1081 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int page = sc.nextInt();
	    long[] ans = new long[10];
	    int point = 1;
	    while (start <= page) {
	        // 끝자리 9로 만들기
	        while (page % 10 != 9 && start <= page) {
	            cal(page, ans, point);
	            page--;
	        }
	        if (page < start) {
	            break;
	        }
	        // 끝자리 0으로 만들기
	        while (start % 10 != 0 && start <= page) {
	            cal(start, ans, point);
	            start++;
	        }
	        start /= 10;
	        page /= 10;
	        for (int i = 0; i < 10; i++) {
	            ans[i] += (page - start + 1) * point;
	        }
	        point *= 10;
	    }
	    long sum=0;
	    for (int i = 0; i < 10; i++) {
	    	sum=sum+ans[i]*i;
	    }
	    System.out.println(sum);
	}
	 
	public static void cal(int x, long[] ans, int point) {
	    while (x > 0) {
	        ans[x % 10] += point;
	        x /= 10;
	    }
	}

}
