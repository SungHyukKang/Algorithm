package jvvv;

import java.util.Scanner;

public class Ring {
	
	public static int gcd(int n ,int m){
		
		while(m>0){
			int temp = n;
			n=m;
			m=temp%m;
		}
		return n;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = sc.nextInt();
		for(int i = 0 ;i<N-1;i++){
			int x=sc.nextInt();
			System.out.println(num/gcd(num,x)+"/"+x/gcd(num,x));
		}
	}

}
