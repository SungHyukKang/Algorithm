package Hash;
import java.util.*;
public class EnglishChain {
	public int[] solution(int n , String[] words){
		HashMap<String ,Integer> hsmap = new HashMap<>();
		int[] answer = new int[2];
		for(int i = 0 ;i<words.length;i++){
			hsmap.put(words[i],hsmap.getOrDefault(words[i], 0)+1);
			if(hsmap.get(words[i])>1){
				answer[0]=i%n+1;
				answer[1]=i/n+1;
				break;
			}
			if(i!=words.length-1)
				if(words[i].charAt(words[i].length()-1)!=words[i+1].charAt(0)){
					answer[0]=(i+1)%n+1;
					answer[1]=(i+1)/n+1;
					break;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		EnglishChain ec = new EnglishChain();
		ec.solution(2,new String[]{"hello","one","even","never","now","world","draw"});
	}

}
