
import java.util.*;
public class Baek2444 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		int N =T*4;
		T=T*2;
		StringBuilder st = new StringBuilder();
		for(int i =0;i<T;i++) {
			if(i%2==1) {
				for(int k =0;k<(T-i)/2;k++) {
					st.append(" ");
				}
				for(int j = 0;j<i;j++) {
					st.append("*");
				}
				st.append("\n");
			}
		}
		for(int i =T-2;i>=0;i--) {
			if(i%2==1) {
				for(int k =0;k<(T-i)/2;k++) {
					st.append(" ");
				}
				for(int j = 0;j<i;j++) {
					st.append("*");
				}
				st.append("\n");
			}
		}
		System.out.println(st);
	}

}
