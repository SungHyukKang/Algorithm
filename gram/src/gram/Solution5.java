package gram;

import java.util.*;

public class Solution5 {
	public static int[] solution(long n){
		
		Long N = n;
		String z =N.toString();
		int[] answer = new int[z.length()];
		int count=0;
		List<Integer> list = new ArrayList<>();
		for(char c : z.toCharArray()){
			if(Character.isDigit(c)){
				answer[count++]=Integer.parseInt(c+"");
				System.out.println(answer[count-1]);
			};
		}
		for(int b : answer){
			list.add(b);
			
		}
		Collections.reverse(list);
		count = 0;
		for(int b : list){
			answer[count++]=b;
			System.out.println(answer[count-1]);
		}
		System.out.println(list);
		
		return answer;
	}
	
	public static void main(String[] args){
		Solution5.solution(12345);
	}
}
