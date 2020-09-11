package Search;
import java.util.*;
public class WordConvert {
	static Stack<String> stack = new Stack<>();
	static String ans;
	static String pre ;
	static int count=0;
	static boolean[] visited;
	static String start;
	static int min=2100000000;
	public int solution(String begin, String target, String[] words) {
        ans =target;
        pre =begin;
        start =begin;
        visited= new boolean[words.length];
        stack.push(begin);
        for(int i =0;i<words.length;i++) {
        	if(words[i].equals(begin)) {
        		visited[i]=true;
        		break;
        	}
        }
        dfs(words);
        if(min==2100000000) {
//        	System.out.println(0);
        	return 0;
        }
//        System.out.println(min-1);
		return min;
    }

	public static void dfs(String[] words) {
		if(pre.equals(ans)) {
//			System.out.println("stack : "+stack+"\n pre : "+pre );
			if(min>stack.size()) {
				min=stack.size();
			}
			return;
		}
		for(int i =0;i<words.length;i++) {
//			System.out.println("stack : "+stack+"\n pre : "+pre );
			if(isPossible(words[i])&&!visited[i]) {
				visited[i]=true;
				pre=words[i];
				stack.push(pre);
				dfs(words);
				stack.pop();
				pre=stack.lastElement();
				visited[i]=false;
			}
		}
		
	}
	
	public static boolean isPossible(String w) {
		int cnt = 0;
		for(int i =0;i<w.length();i++) {
			if(w.charAt(i)!=pre.charAt(i)) {
				cnt++;
			}
		}
		if(cnt>1)
			return false;
		return true;
	}
	public static void main(String[] args) {
		WordConvert wc = new WordConvert();
		wc.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"});
	}

}
