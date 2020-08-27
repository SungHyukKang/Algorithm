package jvvv;

import java.util.Scanner;

class Pair5{
	int zero;
	int one;
	
	Pair5(int zero , int one){
		this.zero=zero;
		this.one = one;
	}
	
}

public class funcFibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair5[] fib = new Pair5[41];
		fib[0] = new Pair5(1,0);
		fib[1] = new Pair5(0,1);
		for(int i =2;i<fib.length;i++){
			fib[i]=new Pair5(fib[i-1].zero+fib[i-2].zero,fib[i-1].one+fib[i-2].one);
		}
		for(int i =0;i<N;i++){
			int num = sc.nextInt();
			System.out.println(fib[num].zero+" "+fib[num].one);
		}
	}

}
