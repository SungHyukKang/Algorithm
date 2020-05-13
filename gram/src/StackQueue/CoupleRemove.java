package StackQueue;
import java.util.*;
public class CoupleRemove {

	public int solution(String s){
		Stack<String> stack = new Stack<>();
		for(String X : s.split("")){
			if(stack.isEmpty())
				stack.push(X);
			else{
				if(stack.peek().equals(X)){
					stack.pop();
				}else
					stack.push(X);
			}
		}
		if(stack.size()!=0){
			return 0;
		}else
		return 1;
	}
	
	public static void main(String[] args) {
		CoupleRemove cr = new CoupleRemove();
		cr.solution("baabaa");

	}

}
