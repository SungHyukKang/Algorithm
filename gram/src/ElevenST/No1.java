package ElevenST;
import java.util.*;
public class No1 {
	public static int solution(String S) {
		if(S.contains("aaa")) {
			return -1;
		}
		StringBuffer sb = new StringBuffer();
		for(int i =0;i<S.length();i++) {
			if(S.charAt(i)!='a') {
				sb.append(S.charAt(i));
			}
		}
		
		int answer =(sb.length()+1)*2;
		answer=answer-(S.length()-sb.length());
		return answer;
    }
	public static void main(String[] args) {
		int sum=0;
		System.out.println(solution("example"));
	}//

}
