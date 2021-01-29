package ElevenST;
import java.util.*;
public class Baek2442 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt()*2;
		for(int i =0;i<N;i++) {
			if(i%2==1) {
				for(int k =0;k<(N-i)/2;k++) {
					System.out.print(" ");
				}
				for(int j = 0;j<i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
