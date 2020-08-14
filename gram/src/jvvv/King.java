package jvvv;

import java.util.HashMap;
import java.util.Scanner;

public class King {
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String k =sc.next();
	String r = sc.next();
	HashMap<String ,Integer> hsmap = new HashMap<>();
	int kingX = 0;
	int kingY = 0;
	int rockX = 0;
	int rockY = 0;
	String move="";
	int N = sc.nextInt();
	/**
	 * R = + 1 
	 * L = - 1
	 * B = - 8
	 * T = + 8
	 * RT = + 9
	 * LT = +7
	 * RB = -7
	 * LB = -9
	 * */
	kingX = (int)k.charAt(0)-'A';
	kingY = Integer.parseInt(Character.toString(k.charAt(1)));
	System.out.println(kingX);
	System.out.println(kingY);
	int KingXY = kingX+kingY;
	rockX = 1+(int)r.charAt(0)-'A';
	rockY =Integer.parseInt(Character.toString(r.charAt(1)));
	int rockXY = rockX+rockY;
	hsmap.put("R", 1);
	hsmap.put("L", -1);
	hsmap.put("B", -1);
	hsmap.put("T", +1);	
	int num=0;
	
	for(int i =0  ;i<N;i++){
		move=sc.next();
		
		for(String Z : move.split("")){
			if(Z.equals("R")||Z.equals("L")){
				if(kingY+hsmap.get(Z)<=0&&kingY+hsmap.get(Z)>=9){
					System.out.println(kingY);
					kingY += hsmap.get(Z);
				}
			}else{
				if(kingX+hsmap.get(Z)<0&&kingX+hsmap.get(Z)>=9){
					System.out.println(kingX);
					kingX +=hsmap.get(Z);
				}
			}
		}
		
	}
	System.out.println(kingX);
	System.out.println(kingY);
	}
	
}
