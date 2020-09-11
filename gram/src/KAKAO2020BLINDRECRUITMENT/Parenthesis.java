package KAKAO2020BLINDRECRUITMENT;


public class Parenthesis {
	public static String func(String word) {
		if(word.length()==0) {
			return"";
		}
		int[] cnt = new int[2];
		String u="";
		String v="";
		for(int i =0;i<word.length();i++) {
			if((cnt[0]!=0&&cnt[1]!=0)&&cnt[0]==cnt[1]) {
				break;
			}
			if(word.charAt(i)=='(') {
				u+="(";
				cnt[0]++;
			}else {
				u+=")";
				cnt[1]++;
			}
		}
		v=word.substring(u.length(),word.length());
		if("".equals(u)||u.charAt(0)=='('&&u.charAt(u.length()-1)==')') {
			return u+func(v);
		}else {
			String temp="("+func(v)+")";
			u=u.substring(1,u.length()-1);
			StringBuilder sb =new StringBuilder();
			for(int i =0;i<u.length();i++) {
				if(u.charAt(i)=='(') {
					sb.append(')');
				}else
					sb.append('(');
			}
			return temp+sb.toString();
		}
		
	}
	
	public String solution(String p){
		if(p.equals(""))
			return p;
		return func(p);
	}
	
	public static void main(String[] args) {
		
		Parenthesis pt =new Parenthesis();
		System.out.println(pt.solution("(()())()"));
		
	}

}
