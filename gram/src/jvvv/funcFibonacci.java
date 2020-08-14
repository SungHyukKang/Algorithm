package jvvv;

import java.util.Scanner;

class Pair{
	int zero;
	int one;
	
	Pair(int zero , int one){
		this.zero=zero;
		this.one = one;
	}
	
}

public class funcFibonacci {
	//백준 1003 피보나치 함수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] fib = new Pair[41];
		fib[0] = new Pair(1,0);
		fib[1] = new Pair(0,1);
		for(int i =2;i<fib.length;i++){
			fib[i]=new Pair(fib[i-1].zero+fib[i-2].zero,fib[i-1].one+fib[i-2].one);
		}
		for(int i =0;i<N;i++){
			int num = sc.nextInt();
			System.out.println(fib[num].zero+" "+fib[num].one);
		}
	}

}
