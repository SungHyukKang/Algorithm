package BruteForce;

import java.util.*;

public class SeparateSum {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc =new Scanner(System.in);
		boolean tf =true;
		int X = sc.nextInt();
		for(int i =1;i<X;i++){
			if(getSum(i)==X){
				System.out.println(i);
				tf=false;
				break;
			}
			}
		
		if(tf){
			System.out.println(0);
		}
	}
	public static int getSum(int x){
		int sum=x;
		while(x!=0){
			sum+=x%10;
			x=x/10;
		}
		return sum;
	}
}
