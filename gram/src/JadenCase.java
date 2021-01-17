import java.util.*;

public class JadenCase {
	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		s=s.toLowerCase();
		for(int i =0;i<s.length();i++) {
			char x =s.charAt(i);
			System.out.println(sb);
			if(x==' ') {
				sb.append(x);
			}else {
				for(int j=i;j<s.length();j++) {
					char z = s.charAt(j);
					if(j==i) {
						sb.append(Character.toString(z).toUpperCase());
						continue;
					}
					if(z==' ') {
						i=j-1;
						break;
					}else
						sb.append(z);
				}
			}
		}
			
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution("for the last week "));
	}

}
