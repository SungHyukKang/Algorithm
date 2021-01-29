import java.util.Scanner;

public class Baek19999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		
		String X = (int)Math.pow(N, 2)+"000";
		System.out.println(X+" "+X);
	}
}
