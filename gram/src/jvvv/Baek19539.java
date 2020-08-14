package jvvv;

import java.util.Scanner;

public class Baek19539 {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int n3=0;
		int n2=0;
		for(int i = 0;i<N;i++){
			int num = sc.nextInt();
			n3+=num;
			n2+=num/2;
		}
		if(n3%3!=0){
			System.out.println("NO");
			return;
		}else{
			n3=n3/3;
			if(n2>=n3){
				System.out.println("YES");
			}else
				System.out.println("NO");
		}
		
		
	}
	
}
