package gram;

public class Calendar {

	public String solution(int a , int b){
		
		int[] month ={31,29,31,30,31,30,31,31,30,31,30,31};
		int days =0;
		
		String[] day={"FRI","SAT","SUN","MON","TUE","WED","THU"};
		if(a!=1)
		for(int i = 0 ;i<a-1;i++){
			days=days+month[i];
		}
		days=days+b-1;
		System.out.println(days);
		String answer = day[days%7];
		System.out.println(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		Calendar cld = new Calendar();
		
		cld.solution(1,1);
		
	}

}
