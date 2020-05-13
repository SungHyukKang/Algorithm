package Greedy;

import java.util.Scanner;

public class Charge {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 1000;
		int pay=sc.nextInt();
		int[] charge = {500,100,50,10,5,1};
		int counter =0;
		int ppp=0;
		money =money-pay;
		while(money!=0){
			if(money<charge[counter]){
				counter++;
				continue;
			}else{
				ppp=(money/charge[counter])+ppp;
				money=money%charge[counter++];
			}
				
		}
		System.out.println(ppp);
	}
	
}
