package jvvv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class WordSort {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr =new ArrayList<>();		
		int N = sc.nextInt();
		String word = null;
		for(int i = 0 ;i<N;i++){
			word = sc.next();
			if(!arr.contains(word))
				arr.add(word);
		}
		Collections.sort(arr);
		Collections.sort(arr,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()>o2.length()){
					return 1;
				}else if(o1.length()<o2.length()){
					return -1;
				}
				else{
					return 0;
				}
			}
		});
		for(String X : arr){
			System.out.println(X);
		}
	}
}
