package jvvv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Jewerly {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		ArrayList<Integer> X = new ArrayList<>();
		ArrayList<Integer> Y = new ArrayList<>();
		for(int i = 0 ;i<N;i++){
			X.add(sc.nextInt());
		}for(int i = 0 ;i<N;i++){
			Y.add(sc.nextInt());
		}
		
		Collections.sort(X);
		Collections.sort(Y,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2){
					return -1;
				}else if(o1<o2)
					return 1;
				return 0;
			}
		});
		int sum= 0;
		for(int i = 0;i<N;i++){
			sum+=X.get(i)*Y.get(i);
		}
		System.out.println(sum);

	}

}
