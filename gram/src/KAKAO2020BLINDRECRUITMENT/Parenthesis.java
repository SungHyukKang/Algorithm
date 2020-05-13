package KAKAO2020BLINDRECRUITMENT;

import java.util.ArrayList;

public class Parenthesis {
	StringBuffer answer = new StringBuffer();
	public String func(String T){
		int x = 0;
		int y = 0;
		StringBuffer u = new StringBuffer();
		StringBuffer v = new StringBuffer();
		for(int i =0;i<T.length();i++){
			if(i==0){
				u.append(T.charAt(i));
				x++;
				continue;
			}
			if(x==y){
					v.append(T.charAt(i));
			}else{	
			if(T.charAt(i)=='('){
				u.append(T.charAt(i));
				x++;
			}else if(T.charAt(i)==')'){
				u.append(T.charAt(i));
				y++;
				}
			}
		}
		if(u.charAt(0)=='('){
			func(v.toString());
		}
		
		
		
		
		answer.append(u);
		return v.toString();
	}
	public String solution(String p){
		
		
		
		/*while(X!=""){
			X=func(X);
			System.out.println(X);
			func(X);
		}*/
		return "";
	}
	
	public static void main(String[] args) {
		
		Parenthesis pt =new Parenthesis();
		pt.solution("()))((()");
		
	}

}
