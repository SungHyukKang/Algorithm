import java.util.*;

public class SkillTree {

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		for (String sk : skill_trees) {
			HashMap<Character,Boolean> hsmap =new HashMap<>();
			for(int i =0;i<skill.length();i++) {
				if(i==0)
					hsmap.put(skill.charAt(i),true);
				else
					hsmap.put(skill.charAt(i),false);
			}
			int idx=1;
			if(skill.length()==1)
				idx=0;
				
			boolean tf=false;
			for(int i =0;i<sk.length();i++) {
				if(hsmap.get(sk.charAt(i))==null) {
					continue;
				}else if(hsmap.get(sk.charAt(i))) {
					hsmap.put(skill.charAt(idx),true);
					if(idx<skill.length()-1)
						idx++;
				}else if(!hsmap.get(sk.charAt(i))) {
					tf=true;
					break;
				}
			}
			if(!tf) {
				answer++;
			}
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		solution("C", new String[] { "BACDE", "CBADF", "AECB", "BDA" });
	}

}
