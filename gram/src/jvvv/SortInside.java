package jvvv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SortInside {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String X = sc.next();
		ArrayList<Integer> arr =new ArrayList<>();
		for(String Z : X.split("")){
			arr.add(Integer.parseInt(Z));
		}
		Collections.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2){
					return -1;
				}else if(o1<o2)
					return 1;
				return 0;
			}
		});
		for(int i =0 ;i<arr.size();i++){
			System.out.print(arr.get(i));
		}
	}
	
	
}
