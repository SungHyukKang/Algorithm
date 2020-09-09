import java.util.*;
public class Baek1920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer,Integer> A = new HashMap<>();
		int N = sc.nextInt();
		for(int i = 0;i<N;i++) {
			A.put(sc.nextInt(),1);
		}
		int M =sc.nextInt();
		for(int i =0;i<M;i++) {
			int num =sc.nextInt();
			if(A.get(num)!=null) {
				System.out.println(A.get(num));
			}else
				System.out.println("0");
		}
		
		
	}

}
