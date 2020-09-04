package jvvv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baek2512 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		int sum2 =0;
		for(int i =0;i<N;i++) {
			list.add(sc.nextInt());
			sum2+=list.get(i);
		}
		double budget=sc.nextDouble();
		int max=0;
		int sum =(int)budget/N;
		max=sum;
		Collections.sort(list);
		if(sum2<=budget) {
			System.out.println(list.get(list.size()-1));
			return;
		}
		for(int i =0;i<N-1;i++) {
			if(sum>=list.get(i)) {
				budget=budget-list.get(i);
				sum=(int)budget/(N-i-1);
				if(max<sum) {
					max=sum;
				}
			}
			
		}
		System.out.println(max);
	}

}
