package jvvv;

import java.util.HashMap;
import java.util.Scanner;

public class RoomNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashMap<Integer,Integer> hsmap = new HashMap<>();
		String X =sc.next();
		hsmap.put(6, 0);
		for(String Z : X.split("")){
			if(Z.equals("9"))
				Z="6";
			hsmap.put(Integer.parseInt(Z),hsmap.getOrDefault(Integer.parseInt(Z), 0)+1);
		}
		hsmap.put(6, (int)Math.ceil((double)hsmap.get(6)/2));
		int max = 0;
		System.out.println(hsmap);
		for(int Z : hsmap.values()){
			if(max<Z){
				max=Z;
			}
		}
		System.out.println(max);
	}
}
