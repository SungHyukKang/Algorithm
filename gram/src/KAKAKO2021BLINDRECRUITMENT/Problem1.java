package KAKAKO2021BLINDRECRUITMENT;

import java.util.regex.Pattern;
import java.util.*;

public class Problem1 {
	public String solution(String new_id) {
        String answer = "";
        String pattern = "^[a-z]*$";
        String numPattern="^[0-9]*$";
        new_id=new_id.toLowerCase();
        boolean regex;
        boolean regex2;
        for(int i =0;i<new_id.length();i++) {
        	regex= Pattern.matches(pattern,Character.toString(new_id.charAt(i)));
        	regex2=Pattern.matches(numPattern,Character.toString(new_id.charAt(i)));
        	if(regex||regex2||new_id.charAt(i)=='-'||new_id.charAt(i)=='_'||new_id.charAt(i)=='.') {
        		answer+=new_id.charAt(i);
        	}
        }
        for(int i =0;i<answer.length();i++) {
        	answer=answer.replace("..",".");
        	if(answer.startsWith(".")) {
            	answer=	answer.substring(1,answer.length());
            }
            if(answer.endsWith(".")) {
            	answer =answer.substring(0,answer.length()-1);
            }
        }
        if("".equals(answer)) {
        	answer ="a";
        }
        if(answer.length()>=16) {
        	answer=answer.substring(0,15);
        }
        for(int i =0;i<answer.length();i++) {
        	if(answer.startsWith(".")) {
            	answer=	answer.substring(1,answer.length());
            }
            if(answer.endsWith(".")) {
            	answer =answer.substring(0,answer.length()-1);
            }
        }
        if("".equals(answer)) {
        	answer ="a";
        }
        String last = answer.substring(answer.length()-1,answer.length());
        while(answer.length()<=2) {
        	answer=answer+last;
        }
        return answer;
    }
	public static void main(String[] args) {
		Problem1 pb = new Problem1();
		pb.solution(".....");
				
	}

}
