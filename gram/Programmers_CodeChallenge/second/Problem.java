package second;

public class Problem {
	public static int solution(int n) {
        int answer = 0;
        int num =n;
        StringBuilder sb =new StringBuilder();
        while(num>0) {
        	sb.append(num%3);
        	num=num/3;
        }
        sb=sb.reverse();
        int sum=0;
        for(int i =0;i<sb.length();i++) {
        	if(sb.charAt(i)=='0')
				continue;
        	int x = (int)Math.pow(3,i);
        	sum+=x*Integer.parseInt(Character.toString(sb.charAt(i)));
        }
        System.out.println(sum);
        return answer;
    }
	public static void main(String[] args) {
		solution(45);
	}

}
