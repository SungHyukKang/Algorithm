package KAKAO2020BLINDRECRUITMENT;

import java.util.*;

public class WordArchive {

	public int solution(String s){
		int min = s.length();
		for(int i =1;i<=s.length()/2;i++) {
			StringBuilder sb=new StringBuilder();
			int cnt=1;
			String v="";
			String cpy="";
			for(int j =0;j<=s.length();j+=i) {
				String X="";
				if(j+i>s.length()) {
					sb.append(s.substring(j));
				}else {
					 X = s.substring(j,j+i);
					 if(v.equals(X)) {
						 if(cnt==1) {
							 String z  = sb.toString().substring(0,sb.length()-i);
							 sb=new StringBuilder();
							 sb.append(z);
							 cpy=v;
						 }
						 cnt++;
					 }else {
						 if(cnt!=1) {
							 sb.append(cnt+cpy+X);
							 cnt=1;
						 }else {
							 sb.append(X);
							 cnt=1;
						 }
					 }
				}
				v=X;
			}
			if(cnt!=1) {
				sb.append(cnt+cpy);
			}
			min=Math.min(min,sb.length());
		}
		return min;
	}

	public static void main(String[] args) {
		WordArchive wa = new WordArchive();
		wa.solution("aabbaccc");
		wa.solution("ababcdcdababcdcd");
		wa.solution("abcabcdede");
		wa.solution("abcabcabcabcdededededede");
		wa.solution("xababcdcdababcdcd");
	}
}
