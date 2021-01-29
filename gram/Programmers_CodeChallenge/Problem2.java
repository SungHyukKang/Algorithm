import java.util.*;
public class Problem2 {
	public static int[] solution(String s) {
        int[] answer = new int[2];
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<s.length();i++) {
        	stack.add(Integer.parseInt(Character.toString(s.charAt(i))));
        }
        int cnt=0;
        int ans=0;
        StringBuilder sb=new StringBuilder();
        while(true) {
        	int X  = stack.pop();
        	if(X==0) {
        		cnt++;
        	}else {
        		sb.append(1);
        	}
        	if(stack.size()==0) {
        		String x =Integer.toBinaryString(sb.toString().length());
        		ans++;
        		for(int i =0;i<x.length();i++)
        			stack.push(Integer.parseInt(Character.toString(x.charAt(i))));
        		if(stack.size()==1)
        			break;
        		sb=new StringBuilder();
        	}
        	
        }
        answer[0]=ans;
        answer[1]=cnt;
        return answer;
    }
	public static void main(String[] args) {
		solution("110010101001");
	}

}
