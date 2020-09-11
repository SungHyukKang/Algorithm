package StackQueue;

import java.util.*;

public class Ironstick {

	public int solution(String arrangement){
		StringBuffer sb  = new StringBuffer(arrangement.replace("()", "l"));
		ArrayList<Character> arr = new ArrayList<>();
		for(int i = 0 ;i <sb.length();i++){
			arr.add(sb.charAt(i));
		}
		ArrayList<Character> stack = new ArrayList<>();
		int answer = 0;
		for(int i = 0 ;i<arr.size();i++){
			if(arr.get(i)=='('){
				stack.add('(');
			}else if(arr.get(i)==')'){
				stack.remove(stack.size()-1);
				answer+=1;
			}else if(arr.get(i)=='l'){
				answer+=stack.size();
			}
		}
		
		System.out.println(answer);
		
		return answer;
	}
	
	public static void main(String[] args){
		Ironstick is = new Ironstick();
		is.solution("()(((()())(())()))(())");
	}
	
}
