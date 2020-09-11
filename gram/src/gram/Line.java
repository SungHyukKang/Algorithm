package gram;

import java.util.Scanner;

interface myfunction{
	public abstract int plus(int a ,int b);
}


public class Line {
	
	
	
	
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Line ln = new Line();
		myfunction f = (int a , int b)->{
			return a+b;
		};
		
		System.out.println(f.plus(5, 7));
		

	}

}
