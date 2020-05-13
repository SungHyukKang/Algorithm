package Greedy;

public class Joystick {
	public static int solution(String name){
		int answer = 0;
        int exp = name.length() - 1;
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            answer += ('Z'- c + 1) > c - 'A' ? c - 'A' : ('Z' - c + 1);
            if(c == 'A'){
                int nextIdx = i+1;
                int countA = 0;
                while (nextIdx < name.length() &&
                       name.charAt(nextIdx) == 'A'){
                    countA ++;
                    nextIdx++;
                }
                int tmp = (i-1)*2 + (name.length() -1 -i - countA) ;
                if(exp > tmp) exp = tmp;
            }
        }

        answer += exp;
        return answer;
	}
	public static void main(String[] args) {
		System.out.println(Joystick.solution("AXXXXA"));
	}
}
/*
A=65
N=78(Áß°£)
Z=90

*/