package gram;

import java.util.ArrayList;
import java.util.Collections;

public class Solution10 {

	public static String solution(String s){
		String answer="";
		ArrayList<Integer> lr = new ArrayList<>();
		for(String s1 : s.split(" ")){
			int x =Integer.parseInt(s1);
			lr.add(x);
		}
		Collections.sort(lr);
		
		int max = lr.get(0);
		int min = lr.get(lr.size()-1);
		System.out.println(max+" "+min);
		answer = (max+" "+min).toString();
		
		return answer;
	}
	public static void main(String[] args) {	
		Solution10.solution("-1 -1");
		
		String X ="01";
		int Y =1;
		int z = Integer.parseInt(X);
		
		System.out.println(z);
		System.out.println(Y);
		
		
		if(Y>z){
			System.out.println("Y"+Y);
		}else if(Y<z){
			System.out.println("z"+z);
		}else
			System.out.println("°°À¸");
		
		
	}

}
