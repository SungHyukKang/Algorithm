import java.util.Scanner;

public class Baek20004{
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int A =sc.nextInt();
		for(int i =1;i<=A;i++) {
			if(30%(i+1)==0) {
				System.out.println(i);
			}
		}
	}

}
