package jvvv;

import java.util.Scanner;

public class Stick {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int sum = 0;
		int cnt = 0;
		int n =6;
		while(X!=0){
			if(Math.pow(2, n)<=X){
				X-=Math.pow(2, n--);
				cnt++;
			}
			else
				n--;
		}
		System.out.println(cnt);
		
	}

}
