package Search;

import java.util.regex.Pattern;

public class 프로그래머스_수식최대화 {
	
	
	public static long solution(String expression) {
        long answer = 0;
        String z=expression;
        for(int i =0;i<expression.length();i++) {
        	if(expression.charAt(i)=='*'||expression.charAt(i)=='/'||expression.charAt(i)=='-'||expression.charAt(i)=='+')
        		continue;
        		expression = expression.replace(Character.toString(expression.charAt(i)),"");
        }
        System.out.println(expression);
        System.out.println(z);
        return answer;
    }
	public static void dfs() {
		
	}
	
	public static void main(String[] args) {
		solution("100-200*300-500+20");
	}

}
