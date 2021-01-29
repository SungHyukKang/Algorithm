import java.util.*;

public class 점프와순간이동 {
	public static int solution(int n) {
		int ans = 1;
		int cnt =1;
		while(ans!=n) {
			if(n%2==0) {
				n=n/2;
			}else {
				n--;
				cnt++;
			}
		}
		
		return cnt;
	}
	public static void main(String[] args) {
		solution(6);
	}

}
