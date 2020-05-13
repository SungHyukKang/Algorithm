package gram;

import java.io.BufferedReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class LimitNum {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String A ="5161";
		String B ="9812";
		
		ArrayList<Integer> arrA = new ArrayList<>();
		for(int i = 0 ;i<A.length();i++)
			arrA.add(Character.getNumericValue(A.charAt(i)));
		ArrayList<Integer> arrB = new ArrayList<>();
		for(int i = 0 ;i<B.length();i++){
			arrB.add(Character.getNumericValue(B.charAt(i)));
		}
		
		
		
		}
}
