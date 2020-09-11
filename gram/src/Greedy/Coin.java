package Greedy;

import java.util.Scanner;

public class Coin {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		Scanner sc= new Scanner(System.in);
		int x = sc.nextInt();
		int money = sc.nextInt();
		int[] charge = new int[x];
		for(int i = 0;i<x;i++){
			charge[i]=sc.nextInt();
		}
		int count = x-1;
		int ppp = 0;
		while(money!=0){
			if(money<charge[count]){
				count--;
				continue;
			}else{
				ppp=(money/charge[count])+ppp;
				money=money%charge[count--];
			}
		}
		System.out.println(ppp);
		
	}

}
